init()

function init() {
    const stat = document.getElementsByClassName("stat");
    for (const statElement of stat) {
        statElement.addEventListener("change", scoreModifier);
    }
    const modifierValueOfDexterity = document.getElementById("dexter");
    modifierValueOfDexterity.addEventListener("change", armorClassModifier);
    modifierValueOfDexterity.addEventListener("change", initiativeModifier);

    const modifierValueOfWisdom = document.getElementById("wisdom");
    modifierValueOfWisdom.addEventListener("change", passiveWisdomModifier);
    const levelValue = document.getElementById("level");
    levelValue.addEventListener("change", proficiencyBonusModifier);
    levelValue.addEventListener("change", updateHitDice);

    const checkBoxes = document.getElementsByClassName("add-profBonus");
    for (const checkBox of checkBoxes) {
        checkBox.addEventListener("change", activateCheckboxes);
    }
    const playerClass = document.querySelector('.character-class');
    playerClass.addEventListener("change", updateHitDice);
}

function scoreModifier(e) {
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

    if (profBonus.value !== document.getElementById("level").value) {
        profBonus.value = document.getElementById("level").value;
        const checkBoxes = document.getElementsByClassName("add-profBonus");
        for (const checkBox of checkBoxes) {
            refreshCheckboxes(checkBox);
        }

    }
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
    if (e.currentTarget.checked) {
        place.innerHTML = parseInt(profBonus) + parseInt(modifier);
    } else {
        place.innerHTML = modifier;
    }
}

function updateHitDice() {
    const totalHd = document.getElementById("total-hd");

    const levelText = document.getElementById("level");
    const classValue = document.getElementById("class");
    totalHd.value = levelText.options[levelText.selectedIndex].text + 'd' + classValue.options[classValue.selectedIndex].value;
}

function refreshCheckboxes(checkBox) {
    const place = checkBox.parentElement.children[1];
    const scoreName = place.className;
    const profBonus = document.getElementById("level").value;
    const modifier = document.getElementById(scoreName).innerText;
    if (checkBox.checked) {
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
