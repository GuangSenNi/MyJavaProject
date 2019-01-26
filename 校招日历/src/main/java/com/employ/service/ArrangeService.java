package com.employ.service;

import com.employ.dao.ArrangeDao;
import com.employ.model.Arrange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
//@ResponseBody
public class ArrangeService {
    @Autowired
    private ArrangeDao arrangeDao;

    @RequestMapping("/findMsg")
    @ResponseBody
    public List<Arrange> findMsg(@RequestParam("data0") String data0){
        System.out.println(data0);
        String[] temp=data0.split("-");
        int t=Integer.parseInt(temp[2]); //date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,t);
        String time=sdf.format(cal.getTime())+" 23:00:00";

        if(temp[0].equals("academic")){
            return arrangeDao.findByAcademic0(temp[1],time);
        }else{
            return arrangeDao.findByMajor0(temp[1],time);
        }

    }


    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}
