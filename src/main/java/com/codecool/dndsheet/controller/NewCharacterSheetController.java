package com.codecool.dndsheet.controller;

import com.codecool.dndsheet.config.TemplateEngineUtil;
import com.codecool.dndsheet.dao.CharacterDaoJDBC;
import com.codecool.dndsheet.manager.DataBaseManager;
import com.codecool.dndsheet.model.DndCharacter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/new-character"})
public class NewCharacterSheetController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String charName = request.getParameter("charName");
        int charClass = Integer.parseInt(request.getParameter("class"));
        int level = Integer.parseInt(request.getParameter("level"));
        int strengthCore = Integer.parseInt(request.getParameter("strengthCore"));
        int dexterityScore = Integer.parseInt(request.getParameter("dexterityScore"));
        int constitutionScore = Integer.parseInt(request.getParameter("constitutionScore"));
        int wisdomScore = Integer.parseInt(request.getParameter("wisdomScore"));
        int intelligenceScore = Integer.parseInt(request.getParameter("intelligenceScore"));
        int charismaScore = Integer.parseInt(request.getParameter("charismaScore"));

        DataBaseManager dataBaseManager = new DataBaseManager();
        dataBaseManager.run();

        DndCharacter character = new DndCharacter(charName, charClass, level, strengthCore, dexterityScore, constitutionScore, wisdomScore, intelligenceScore, charismaScore);

        CharacterDaoJDBC characterDaoJDBC = dataBaseManager.getCharacterDaoJDBC();
        characterDaoJDBC.add(character);

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());
        engine.process("add-character.html", context, response.getWriter());

    }
}
