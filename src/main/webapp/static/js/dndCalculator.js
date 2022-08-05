init()

function init(){
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
    // const checkBoxes = document.getElementsByClassName("add-profBonus");
    let checkboxSibling = e.currentTarget.parentElement.children[1].innerHTML;
    const dataModifiers = document.querySelectorAll('[data-modifier]');
    const classOfClickedCheckbox = e.currentTarget.parentElement.children[1].className;
    // console.log(classOfClickedCheckbox);
    for (const dataModifier of dataModifiers) {
        if (dataModifier.dataset.modifier === classOfClickedCheckbox) {
            // console.log(document.getElementById("level").value);
            // console.log(dataModifier);
            console.log(checkboxSibling);
            //console.log(parseInt(dataModifier.innerHTML));
            checkboxSibling = (parseInt(document.getElementById("level").value) + parseInt(dataModifier.innerHTML)).toString();
            e.currentTarget.parentElement.children[1].innerHTML = checkboxSibling;
        }
    }
}

function passiveWisdomModifier(e) {
    const baseArmor = 10;
    const passiveWisdomDiv = document.getElementById("passiveWisdom");
    passiveWisdomDiv.value = baseArmor + parseInt(document.querySelector('[data-modifier="wis"]').innerHTML);
}

