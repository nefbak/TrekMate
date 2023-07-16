// let popup = document.getElementById("popup");

// function openPopup(){
//     popup.classList.add("open-popup");
// }

// function closePopup(){
//     popup.classList.remove("open-popup");
// }

// var n = window.prompt("name?", "Chesca")
// window.alert("sup " + n)

const revPop = document.querySelector('.revPopup');
const openRev = document.querySelector('.revButton');
const closeRev = document.querySelector('.closeRev');

const delPop = document.querySelector('.deletePopup');
const openDel = document.querySelector('.deleteButton');
const cancelDel = document.querySelector('.closeDelete');


openRev.addEventListener('click', () => {
    revPop.showModal();
})

closeRev.addEventListener('click', () => {
    revPop.close();
})

openDel.addEventListener('click', () => {
    delPop.showModal();
})

cancelDel.addEventListener('click', () => {
    delPop.close();
})