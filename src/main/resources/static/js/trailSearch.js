const searchWrapper = document.querySelector(".search-bar");
const inputBox = searchWrapper.querySelector("input");
const suggBox = searchWrapper.querySelector(".autocom-box");
const searchButton = document.querySelector("#search");

searchButton.addEventListener("click", showSearch);

var searchShow = false;


inputBox.onkeyup = (e)=>{

    let userData = e.target.value;
    let emptyArray = [];
    if(userData){

        emptyArray = suggestions.filter((data)=>{
            return data.toLocaleLowerCase().startsWith(userData.toLocaleLowerCase());
        });


        emptyArray = emptyArray.map((data)=>{
            return data = '<li>'+ data +'</li>';
        });

        console.log(emptyArray);
        searchWrapper.classList.add("active");
        showSuggestions(emptyArray);
        let allList = suggBox.querySelectorAll("li");
        

        for(let i= 0; i < allList.length; i++){
           allList[i].setAttribute("onclick","select(this)");
        }
    }
    else{
        searchWrapper.classList.remove("active");
    }

    
}



function select(element){
    let selectUserData = element.textContent;
    inputBox.value = selectUserData;
    searchWrapper.classList.remove("active");
}

function showSuggestions(list){
    let listData;
    if(!list.length){
        userValue = inputBox.value;
        listData = '<li>' + userValue + '</li>';
    }
    else{
        listData = list.join('');
    }
    suggBox.innerHTML = listData;
}

function showSearch(){
    if (searchShow == false){
        searchWrapper.classList.add("search-bar-move");
        searchWrapper.classList.add("search-bar-show");
        searchShow = true;
    }
    else if (searchShow == true){
        searchWrapper.classList.add("search-bar-hide");
        searchWrapper.classList.remove("search-bar-move");
        searchShow = false;
        searchWrapper.classList.remove("search-bar-show");
    }

}