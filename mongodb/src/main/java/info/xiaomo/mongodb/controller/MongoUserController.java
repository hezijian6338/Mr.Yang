package info.xiaomo.mongodb.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import info.xiaomo.core.base.Result;
import info.xiaomo.core.constant.CodeConst;
import info.xiaomo.mongodb.model.MongoUser;
import info.xiaomo.mongodb.service.MongoUserService;
import io.swagger.annotations.Api;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.stream.FileImageOutputStream;
import javax.persistence.Convert;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Date;
import java.util.List;

/**
 * 把今天最好的表现当作明天最新的起点．．～
 * いま 最高の表現 として 明日最新の始発．．～
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 *
 * @author : xiaomo
 * github: https://github.com/xiaomoinfo
 * email: xiaomo@xiaomo.info
 * <p>
 * Date: 2016/11/15 15:49
 * Copyright(©) 2015 by xiaomo.
 **/

@RestController
@RequestMapping("mongodb")
@Api("mongodb測試")
public class MongoUserController {

    private final MongoUserService service;

    @Autowired
    public MongoUserController(MongoUserService service) {
        this.service = service;
    }

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Result get(@PathVariable("id") Long id) {
        MongoUser mongoUser = service.findById(id);
        return new Result<>(mongoUser);
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public Result findAll() {
        return new Result<>(service.findAll());
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Result add(@RequestBody MongoUser user) {
        // user.setImg(file);
        return new Result<>(service.add(user));
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Result upload(@RequestParam("file") MultipartFile file) {
        // GridFS gridFS = new GridFS(mongodbfactory.getLegacyDb(), "photo");
        // LOGGER.info("Saving file..");
        DBObject metaData = new BasicDBObject();
        metaData.put("createdDate", new Date());

        String fileName = file.getOriginalFilename();

        // LOGGER.info("File Name: " + fileName);

        InputStream inputStream = null;

        ObjectId  objectId;
        try {
            inputStream = file.getInputStream();
            objectId = gridFsTemplate.store(inputStream, fileName, file.getContentType(), metaData);
            // LOGGER.info("File saved: " + fileName);
        } catch (IOException e) {
            // LOGGER.error("IOException: " + e);
            throw new RuntimeException("System Exception while handling request");
        }
        // LOGGER.info("File return: " + fileName);
        return new Result<>(objectId);
    }

    @RequestMapping(value = "img", method = RequestMethod.GET)
    public byte[] get(@RequestParam(value = "fileName", required = true) String fileName) throws IOException {
        // LOGGER.info("Getting file.." + fileName);
        GridFSFindIterable result = gridFsTemplate
                .find(new Query().addCriteria(Criteria.where("filename").is(fileName)));
        if (result == null) {
            // LOGGER.info("File not found" + fileName);
            throw new RuntimeException("No file with name: " + fileName);
        }
        GridFsResource gridFsResource = gridFsTemplate.getResource(fileName);
        // LOGGER.info("File found " + fileName);
        byte[] data = IOUtils.toByteArray(gridFsResource.getInputStream());
        File imageFile = new File("D:\\" + gridFsResource.getFilename());
        FileImageOutputStream imageOutput = new FileImageOutputStream((imageFile));
        imageOutput.write(data, 0, data.length);
        imageOutput.close();

        String encoded = Base64.getEncoder().encodeToString(data);

        System.out.println(encoded);
        return data;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public Result delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new Result(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage());
    }

}
