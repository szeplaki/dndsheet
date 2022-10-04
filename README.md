# Dungeon and Dragons(DND) sheet filler

## What is DND? 
Dungeons & Dragons (commonly abbreviated as D&D or DnD) is a fantasy tabletop role-playing game (RPG).
D&D departs from traditional wargaming by allowing each player to create their own character to play instead of a military formation. These characters embark upon imaginary adventures within a fantasy setting. A Dungeon Master (DM) serves as the game's referee and storyteller, while maintaining the setting in which the adventures occur, and playing the role of the inhabitants of the game world. The characters form a party and they interact with the setting's inhabitants and each other. Together they solve dilemmas, engage in battles, explore, and gather treasure and knowledge. In the process, the characters earn experience points (XP) in order to rise in levels, and become increasingly powerful over a series of separate gaming sessions.

## Requirements to use the sheet filler

### 1. Install IntelliJ IDEA:

https://www.jetbrains.com/help/idea/installation-guide.html#requirements

### 2/a Set Up a PostgreSQL Database on Linux

https://www.microfocus.com/documentation/idol/IDOL_12_0/MediaServer/Guides/html/English/Content/Getting_Started/Configure/_TRN_Set_up_PostgreSQL_Linux.htm

### 2/b Set Up a PostgreSQL Database on Windows

https://www.microfocus.com/documentation/idol/IDOL_12_0/MediaServer/Guides/html/English/Content/Getting_Started/Configure/_TRN_Set_up_PostgreSQL.htm

### 2/c Set Up a PostgreSQL Database on MAC

https://www.sqlshack.com/setting-up-a-postgresql-database-on-mac/


### 3. Open a project in IntelliJ IDEA

https://www.jetbrains.com/help/idea/open-close-and-move-projects.html
(As this is a maven project, click the pom.xml to start, and in the pop-up window choose "open as a project" button)


### 4. Configure environment variables

- Click "Run" -> "Edit Configurations" -> (if needed: "Java Options" -> ) "Environment Variables"
- Fill it out:
  * PSQL_DB_NAME = Your database name; 
  * PSQL_PASSWORD = Your psql password; 
  * PSQL_USER_NAME = Your psql username;
  
### 5. Run the project and go to http://localhost:8080/

## Used technologies

Java, SQL, Thymeleaf, Servlets, Java DAO pattern, JavaScript, HTML, CSS

## The sheet itself can be found on the internet, I borrowed it for my work: 

https://media.wizards.com/2016/dnd/downloads/5E_CharacterSheet_Fillable.pdf
