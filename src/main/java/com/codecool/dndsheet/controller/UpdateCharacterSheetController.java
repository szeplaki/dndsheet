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

@WebServlet(urlPatterns = {"/sheetfiller"})
public class UpdateCharacterSheetController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        DataBaseManager dataBaseManager = new DataBaseManager();
        dataBaseManager.run();
        CharacterDaoJDBC characterDaoJDBC = dataBaseManager.getCharacterDaoJDBC();

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());

        int id = Integer.parseInt(req.getParameter("characters"));
        context.setVariable("character", characterDaoJDBC.find(id));
        engine.process("index.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("character"));
        String charName = request.getParameter("charName");
        int charClass = Integer.parseInt(request.getParameter("class"));
        int level = Integer.parseInt(request.getParameter("level"));
        int strengthCore = Integer.parseInt(request.getParameter("strengthCore"));
        int dexterityScore = Integer.parseInt(request.getParameter("dexterityScore"));
        int constitutionScore = Integer.parseInt(request.getParameter("constitutionScore"));
        int wisdomScore = Integer.parseInt(request.getParameter("wisdomScore"));
        int intelligenceScore = Integer.parseInt(request.getParameter("intelligenceScore"));
        int charismaScore = Integer.parseInt(request.getParameter("charismaScore"));
        int copper = Integer.parseInt(request.getParameter("copper"));
        int silver = Integer.parseInt(request.getParameter("silver"));
        int gold = Integer.parseInt(request.getParameter("gold"));

        DataBaseManager dataBaseManager = new DataBaseManager();
        dataBaseManager.run();
        CharacterDaoJDBC characterDaoJDBC = dataBaseManager.getCharacterDaoJDBC();


        DndCharacter character = dataBaseManager.getCharacterDaoJDBC().find(id);
        character.setCharacterName(charName);
        character.setDice(charClass);
        character.setCharacterLevel(level);
        character.setStrength(strengthCore);
        character.setDexterity(dexterityScore);
        character.setConstitution(constitutionScore);
        character.setWisdom(wisdomScore);
        character.setIntelligence(intelligenceScore);
        character.setCharisma(charismaScore);
        character.setCopper(copper);
        character.setSilver(silver);
        character.setGold(gold);
        characterDaoJDBC.update(character);

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());
        context.setVariable("character", characterDaoJDBC.find(id));
        engine.process("index.html", context, response.getWriter());

    }
}
