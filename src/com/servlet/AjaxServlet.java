package com.servlet;

import com.been.User;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = req.getParameter("data");
        System.out.println(data);

        JSONObject jsonObject = JSONObject.fromObject(data);
        System.out.println(jsonObject);

        User user = (User) JSONObject.toBean(jsonObject, User.class);
        System.out.println(user.toString());



        JSONObject data_ = new JSONObject();
        /*向外传输<key, json>的键值对*/
        data_.put("user", jsonObject);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print(data_);


    }
}
