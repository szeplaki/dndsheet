package com.codecool.dndsheet.controller;

import com.codecool.dndsheet.config.TemplateEngineUtil;
import com.codecool.dndsheet.dao.CharacterDaoJDBC;
import com.codecool.dndsheet.manager.DataBaseManager;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/"})
public class MainPageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DataBaseManager dataBaseManager = new DataBaseManager();
        dataBaseManager.run();
        CharacterDaoJDBC characterDaoJDBC = dataBaseManager.getCharacterDaoJDBC();

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());

        engine.process("main-page.html", context, resp.getWriter());
    }
}
