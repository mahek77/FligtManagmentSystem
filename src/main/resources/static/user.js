window.onload = function(){
loadFlights();
};
function loadFlights() {
fetch("/flights")
.then(function(response) {
return response.json();
})
.then(function(flights) {
var table = document.getElementById("flightTable");

table.innerHTML = "";

for(var i =0;i<flights.length;i++){
var f = flights[i];

if(f.available_seats >0){
var row =
         "<tr>" +
"<td>" + f.flight_id + "</td>" +
"<td>" + f.flight_no + "</td>" +
"<td>" + f.flight_name + "</td>" +
"<td>" + (f.fromCity ? f.fromCity.city_name : "") + "</td>" +
"<td>" + (f.toCity ? f.toCity.city_name : "") + "</td>" +
"<td>" + f.departureDate + "</td>" +
"<td>" + f.departure_time + "</td>" +
"<td>" + f.ticket_price + "</td>" +
"<td>" + f.available_seats + "</td>" +
"<td><button onclick='selectFlight(" + f.flight_id + ")'>Select</button></td>" +
"</tr>";

table.innerHTML = table.innerHTML +row;
}
}
if(table.innerHTML ===""){
table.innerHTML = "<tr><td colspan='10'>No available flighs found</td></tr>";
}
})
.catch(function(error) {
alert("Flights not loaded");
console.log(error);
});
}

function selectFlight(flightId){
window.location.href = "booking.html?flightId="+flightId;
}

function logout(){
window.location.href = "login.html";
}
