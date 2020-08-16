package com.since.sincethird.controller;

import com.since.sincethird.common.SessionKey;
import com.since.sincethird.entity.Ruser;
import com.since.sincethird.entity.WXUser;
import com.since.sincethird.repository.ReportRepository;
import com.since.sincethird.ret.Code;
import com.since.sincethird.ret.Ret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author jayzh
 */
@Controller
@RequestMapping("/report")
public class ReportController {
    final Code USER_NOT_ENROLL= new Code("1","该用户没有注册，请先注册！");
    final Code USER_ALREADY_EXIST= new Code("1","该该用户已存在！");
    final Code DATA_UPDATE_FAIL= new Code("2","数据异常，更新失败");


    @Autowired
    HttpServletRequest httpServletRequest;
    @Autowired
    ReportRepository reportRepository;

    @RequestMapping("/compare")
    @ResponseBody
    public Ret verify(){
        WXUser user= (WXUser) httpServletRequest.getSession().getAttribute(SessionKey.LOGIN_USER);
        String openid= user.getOpenId();
        Ruser rUser= reportRepository.findRuserByOpenid(openid);
        if (rUser==null){
            return Ret.error(USER_NOT_ENROLL);
        }
        return Ret.success(rUser);
    }


    @RequestMapping("/add")
    @ResponseBody

    public Ret add(@RequestBody HashMap<String, String> map ){
        WXUser user= (WXUser) httpServletRequest.getSession().getAttribute(SessionKey.LOGIN_USER);
        String openid= user.getOpenId();
        String sid=map.get("sid");
        String password=map.get("password");
        String email=map.get("email");
        Ret ret=verify();
        if (ret.getData()!=null){
            return Ret.error(USER_ALREADY_EXIST);
        }else {
            Ruser rUser=new Ruser();
            rUser.setSid(sid).setPassword(password).setEmail(email).setOpenid(openid).setDay(4).setOkday(0).setStatus(1);
            rUser= reportRepository.save(rUser);
            return Ret.success(rUser);
        }

    }
    @RequestMapping("/pay")
    @ResponseBody
    public Ret pay(@RequestBody HashMap<String, String> map){
        Integer day=Integer.parseInt(map.get("day"));
        Ret ret=verify();
        if (ret.getData()==null){
            return Ret.error(USER_NOT_ENROLL);
        }else {
            try {
                Ruser rUser= (Ruser) ret.getData();
                rUser.setDay(rUser.getDay()+day);
                rUser= reportRepository.save(rUser);
                return Ret.success(rUser);
            }catch (Exception e){
                return Ret.error(DATA_UPDATE_FAIL);
            }

        }

    }
    @RequestMapping("/update")
    @ResponseBody
    public Ret change(){
        Ret ret=verify();
        if (ret.getData()==null){
            return Ret.error(USER_NOT_ENROLL);
        }else {
            try {
                Ruser rUser= (Ruser) ret.getData();
                Integer status= Math.abs(rUser.getStatus()-1);
                rUser.setStatus(status);
                rUser= reportRepository.save(rUser);
                return Ret.success(rUser);
            }catch (Exception e){
                return Ret.error(DATA_UPDATE_FAIL);
            }

        }

    }

}
