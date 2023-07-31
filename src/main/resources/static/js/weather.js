const forecasting =  "https://api.weatherapi.com/v1/forecast.json?key=954d22e97c3348de8fd42616233007&";


var trailLoc = document.getElementById("trailLocation").innerHTML;
var dt = new Date();
dt = dt.toLocaleDateString();
var days = 3;

var forecastURL = forecasting.concat("q="+trailLoc+"&days="+days+"&aqi=no&alerts=no");
window.addEventListener("load", getWeatherData);

async function getWeatherData(){
    try{

        //get the current weather and forecast of next 3 days
        let forecastRes = await fetch(forecastURL);
        let forecastRequest = forecastRes.json();
        
        //get all the data
        let todayTemp_c;
        let todayFeelsLike;
        let todayIcon;
        let todayStatus;
        let tmrTemp_C;
        let tmrIcon;
        let tmrStatus;
        let twoDayTemp_C;
        let twoDayIcon;
        let twoDayStatus;

        forecastRequest.then(function jsonify(forecastRequest){
            console.log(forecastRequest);
            //gather data from object
            todayTemp_c = forecastRequest["current"]["temp_c"];
            todayFeelsLike = forecastRequest["current"]["feelslike_c"];
            todayIcon = forecastRequest["current"]["condition"]["icon"];
            todayStatus = forecastRequest["current"]["condition"]["text"]; 
            tmrTemp_C = forecastRequest["forecast"]["forecastday"][1]["day"]["avgtemp_c"];
            tmrIcon = forecastRequest["forecast"]["forecastday"][1]["day"]["condition"]["icon"];
            tmrStatus = forecastRequest["forecast"]["forecastday"][1]["day"]["condition"]["text"];
            twoDayTemp_C = forecastRequest["forecast"]["forecastday"][2]["day"]["avgtemp_c"];
            twoDayIcon = forecastRequest["forecast"]["forecastday"][2]["day"]["condition"]["icon"];
            twoDayStatus = forecastRequest["forecast"]["forecastday"][2]["day"]["condition"]["text"];
            
            //format into html
            let html = '';
            html = '<p class="title">Weather</p> <table> <tr> <th class="day">Today</th> <th class="day">Tomorrow</th> <th class="day">2 Days from Today</th> </tr> <tr> <th class="text">' +
                    todayStatus + '<br> <img src="' + todayIcon + '" alt="no name"> <br>' + todayTemp_c + '°C <br> Feels like: ' + todayFeelsLike + '°C</th>'
                    + '<th class="text">' + tmrStatus + '<br> <img src="' + tmrIcon + '" alt="no name"> <br>' + tmrTemp_C + '°C </th>' 
                    + '<th class="text">' + twoDayStatus + '<br> <img src="' + twoDayIcon + '" alt="no name"> <br>' + twoDayTemp_C + '°C </th>'
                    + '</tr> </table>';
            

            let weather = document.getElementById('weather');
            weather.innerHTML = html;
            console.log(html);
                })  
            }
            catch (error){
                console.log(error);
            }
}
    
