package logAspect.controller;

import logAspect.domain.annocation.LogAnnotation;
import logAspect.domain.model.UserReq;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
@RestController
@RequestMapping("/v0.1/admin")
public class UserController {

    @RequestMapping(value = "/save",name = "保存用户",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @LogAnnotation(action = "保存")
    public Object saveUser(@RequestBody UserReq userReq,String id){
        System.out.println("save");
        return "";
    }

    @RequestMapping(value = "/delete",name = "删除用户",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @LogAnnotation(action = "删除")
    public void deleteUser(@RequestBody UserReq userReq,String id){
        System.out.println("delete");
    }

}
