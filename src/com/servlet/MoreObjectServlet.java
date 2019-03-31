package com.servlet;

import com.been.User;
import net.sf.json.JSONSerializer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoreObjectServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建多个个对象
        List<User> users = new ArrayList<>();
        for(int i = 0; i<10; i++){
            User user = new User();
            user.setName(String.valueOf(i));
            user.setId(i);
            user.setSex(String.valueOf((int)(Math.random()*1)));
            users.add(user);
        }

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().print(JSONSerializer.toJSON(users).toString());


    }
}
