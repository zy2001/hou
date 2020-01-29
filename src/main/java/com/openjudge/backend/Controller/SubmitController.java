package com.openjudge.backend.Controller;

import com.openjudge.backend.DTO.ResponseResult;
import com.openjudge.backend.Mapper.SubmitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;


/**
 * Created by zy on 2020/1/29
 */

@CrossOrigin
@RestController
public class SubmitController {

    @Autowired
    private SubmitMapper submitMapper;

    @PostMapping("/submit")
    public ResponseResult submit(@RequestParam Map<String, Object> params) {
        ResponseResult result = new ResponseResult();
        try {
            //判断来值是否完整
            if (null == params.get("pid"))
                throw new Exception();
            System.out.println("pid:" + params.get("pid"));
            if (null == params.get("uid"))
                throw new Exception();
            System.out.println("uid:" + params.get("uid"));
            if (null == params.get("language"))
                throw new Exception();
            System.out.println("language:" + params.get("language"));
            if (null == params.get("code"))
                throw new Exception();
            System.out.println("code:" + params.get("code"));
            //补充提交参数
            params.put("status", "0");
            params.put("runTime", null);
            params.put("runMemory", null);
            Date date = new Date(System.currentTimeMillis());
            params.put("gmtCreated", date);
            params.put("gmtModified", date);
            //插入提交数据
            boolean flag = submitMapper.insertSubmit(params);
            //插入成功返回成功信息
            if(flag) {
                result.setMessage("提交成功");
                result.setSuccess(true);
                result.setErrorcode("200");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}