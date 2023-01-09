package com.freemarker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Date 2022/9/25
 */
@RestController
public class DownLoadController {


    @GetMapping("/DownLoadController/downDoc")
    public void  downDoc(HttpServletResponse response, String fileName, String tplName){
        Map<String, Object> data = getData();
        response.getStatus();

        System.out.println(1);
    }


    public Map<String,Object> getData(){
        Map<String, Object> map = new HashMap<>();
        map.put("user","user");
        map.put("name","name");
        return map;
    }
}
