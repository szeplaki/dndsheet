init()

function init(){
    const test = document.getElementById("test");
    console.log(test);
    console.log("hello js");
    const stat = document.getElementsByClassName("stat");
    for (const statElement of stat) {
        statElement.addEventListener("change",scoreModifier);
    }
    const modifierValueOfDexterity = document.getElementById("dexter");
    modifierValueOfDexterity.addEventListener("change", armorClassModifier);
    modifierValueOfDexterity.addEventListener("change", initiativeModifier);

    const modifierValueOfWisdom = document.getElementById("wisdom");
    modifierValueOfWisdom.addEventListener("change", passiveWisdomModifier);
    const levelValue = document.getElementById("level");
    levelValue.addEventListener("change", proficiencyBonusModifier);

    const checkBoxes = document.getElementsByClassName("add-profBonus");
    for (const checkBox of checkBoxes) {
        checkBox.addEventListener("change", activateCheckboxes);
    }
}

function scoreModifier(e){
    const modifierCalculator = Math.floor((e.currentTarget.value / 2) - 5);
    const statType = e.currentTarget.parentElement.nextElementSibling.children[0].getAttribute('data-modifier');

    e.currentTarget.parentElement.nextElementSibling.children[0].innerHTML = modifierCalculator;
    const skills = document.getElementsByClassName(statType);
    for (const skill of skills) {
        skill.innerHTML = modifierCalculator;
    }
}

function armorClassModifier(e) {
    const modifierCalculator = Math.floor((e.currentTarget.value / 2) - 5);
    const baseArmor = 10;
    const armorClassDiv = document.getElementById("armor-class");
    armorClassDiv.value = baseArmor + modifierCalculator;
}

function proficiencyBonusModifier(e) {
    const profBonus = document.getElementById("prof-bonus");
    profBonus.value = document.getElementById("level").value;
}

function initiativeModifier(e) {
    const initiative = document.getElementById("initiative");
    initiative.value = parseInt(document.querySelector('[data-modifier="dex"]').innerHTML)
}

function activateCheckboxes(e) {
    const place = e.currentTarget.parentElement.children[1];
    const scoreName = place.className;
    const profBonus = document.getElementById("level").value;
    const modifier = document.getElementById(scoreName).innerText;
    if (e.currentTarget.checked){
        place.innerHTML = parseInt(profBonus) + parseInt(modifier);
    } else {
        place.innerHTML = modifier;
    }
}

function passiveWisdomModifier(e) {
    const baseArmor = 10;
    const passiveWisdomDiv = document.getElementById("passiveWisdom");
    passiveWisdomDiv.value = baseArmor + parseInt(document.querySelector('[data-modifier="wis"]').innerHTML);
}

