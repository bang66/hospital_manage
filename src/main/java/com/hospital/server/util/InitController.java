package com.hospital.server.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InitController {

    @RequestMapping("/websocket")
    public String init() {
        return "websocket";
    }

    @RequestMapping("/showmessage")
    public String init1() {
        return "showmessage";
    }

    @RequestMapping("/show")
    public String init2() {
        return "show";
    }

    @RequestMapping(value = "/send" ,method = RequestMethod.POST)
    @ResponseBody
    public String xxx(@RequestBody JSONObject jsonObject){
        String message = jsonObject.toJSONString();
        System.out.println(message);



        WebSocketServer ws = new WebSocketServer();
        ws.onMessage(message,null);
        return "1";
    }


    @RequestMapping("/index")
    public String init3() {
        return "html/index";
    }
}

