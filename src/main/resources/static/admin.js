window.onload=function(){
loadFlights();
loadBookings();
};
function loadFlights(){
fetch("/flights")
.then(function(response) {
return response.json();
})
.then(function(flights) {
var table = document.getElementById("flightTable");
table.innerHTML = "";

for(var i =0;i<flights.length;i++){
var f = flights[i];
var fromCity = f.fromCity;
var toCity =  f.toCity;
var admin = f.admin;
var fromCityName = "";
var toCityName = "";

if(fromCity){
fromCityName = fromCity.city_name ||"";
}
if(toCity){
toCityName= toCity.city_name || "";
}

var row = "<tr>"+"<td>"+f.flight_id+"</td>"+
"<td>"+f.flight_no+"</td>"+"<td>"+f.flight_name+"</td>"+
"<td>"+fromCityName+"</td>"+ "<td>" + toCityName + "</td>"+
"<td>"+ f.departureDate+ " " +f.departure_time+"</td>"+
"<td>"+f.arrival_date+" "+f.arrival_time+"</td>"+
"<td>"+f.ticket_price+"</td>"+"<td>"+f.total_seats+
"</td>"+"<td>"+f.available_seats+"</td>"+
"<td>"+"<button onclick='editFlight("+f.flight_id+")'>Edit</button> " +
"<button class='delete-btn' onclick='deleteFlight(" + f.flight_id + ")'>Delete</button>" +"</td>" +
"</tr>";

table.innerHTML = table.innerHTML +row;
}

if(table.innerHTML ===""){
table.innerHTML = "<tr><td colspan='11'>No flights found</td></tr>";
}
})
.catch(function(error) {
alert("Flights not loaded");
console.log(error);
});
}

function addFlight(){
var flightNo = document.getElementById("flightNo").value;
var flightName = document.getElementById("flightName").value;
var fromCityId = document.getElementById("fromCityId").value;
var toCityId = document.getElementById("toCityId").value;
var departureDate = document.getElementById("departureDate").value;
var departureTime = document.getElementById("departureTime").value;
var arrivalDate = document.getElementById("arrivalDate").value;
var arrivalTime = document.getElementById("arrivalTime").value;
var ticketPrice = document.getElementById("ticketPrice").value;
var totalSeats = document.getElementById("totalSeats").value;
var availableSeats = document.getElementById("availableSeats").value;
var adminId = document.getElementById("adminId").value;

if(flightNo === ""||flightName===""||fromCityId===""||toCityId===""){
alert("Please fill flight number,flight name,from city and to city");
return;
}

if(departureDate===""||departureTime===""||arrivalDate===""||arrivalTime===""){
alert("Please fill date and time");
return;
}
if(ticketPrice===""||totalSeats===""||availableSeats===""||adminId===""){
alert("Please fill price, seats and admin id");
return;
}

var flight = {
flight_no:flightNo,
flight_name:flightName,
fromCity:{
city_id: Number(fromCityId)
},
toCity: {
city_id: Number(toCityId)
},
departureDate:departureDate,
departure_time:departureTime,
arrival_date:arrivalDate,
arrival_time:arrivalTime,
ticket_price:Number(ticketPrice),
total_seats:Number(totalSeats),
available_seats: Number(availableSeats),
admin_id: {
admin:Number(adminId)
}

};

fetch("/flights/add", {method:"POST",headers:{"content-Type":"application/json"},body: JSON.stringify(flight)})
.then(function(response) {
if(response.ok){
alert("Flight added successfully");
clearForm();
loadFlights();
window.location.href="#allFlightsSection";
}else{
alert("Flight not added, Check City Id and admin Id");
}
})
.catch(function(error) {
alert("Add flight error");
console.log(error);
});
}
function editFlight(id) {
    fetch("/flights/" + id)
        .then(function (response) {
            return response.json();
        })
        .then(function (f) {
            var fromCity =  f.fromCity;
            var toCity =  f.toCity;
            var admin = f.admin;
            document.getElementById("flightId").value = f.flight_id;
            document.getElementById("flightNo").value = f.flight_no;
            document.getElementById("flightName").value = f.flight_name;
            if (fromCity) {
                document.getElementById("fromCityId").value = fromCity.city_id;
            }
            if (toCity) {
                document.getElementById("toCityId").value = toCity.city_id;
            }
            document.getElementById("departureDate").value = f.departureDate;
            document.getElementById("departureTime").value = f.departure_time;
            document.getElementById("arrivalDate").value = f.arrival_date;
            document.getElementById("arrivalTime").value = f.arrival_time;
            document.getElementById("ticketPrice").value = f.ticket_price;
            document.getElementById("totalSeats").value = f.total_seats;
            document.getElementById("availableSeats").value = f.available_seats;
            if (admin) {
                document.getElementById("adminId").value = admin.admin_id;
            }

            window.location.href = "#addFlightSection";
        })
        .catch(function (error) {
            alert("Flight not loaded for edit");
            console.log(error);
        });
}
function updateFlight() {
    var id = document.getElementById("flightId").value;

    if (id === "") {
        alert("Please click Edit button first");
        return;
    }

    var flight = {
        flight_no: document.getElementById("flightNo").value,
        flight_name: document.getElementById("flightName").value,
        fromCity: {
            city_id: Number(document.getElementById("fromCityId").value)
        },
        toCity: {
            city_id: Number(document.getElementById("toCityId").value)
        },
        departure_date: document.getElementById("departureDate").value,
        departure_time: document.getElementById("departureTime").value,
        arrival_date: document.getElementById("arrivalDate").value,
        arrival_time: document.getElementById("arrivalTime").value,
        ticket_price: Number(document.getElementById("ticketPrice").value),
        total_seats: Number(document.getElementById("totalSeats").value),
        available_seats: Number(document.getElementById("availableSeats").value),
        admin: {
            admin_id: Number(document.getElementById("adminId").value)
        }
    };

    fetch("/flights/update/"+id,{method: "PUT",headers: {"Content-Type": "application/json"},body: JSON.stringify(flight)})
    .then(function (response) {
        if (response.ok) {
            alert("Flight updated successfully");
            clearForm();
            loadFlights();
            window.location.href = "#allFlightsSection";
        } else {
            alert("Flight not updated");
        }
    })
    .catch(function (error) {
        alert("Update flight error");
        console.log(error);
    });
}
function deleteFlight(id) {
    var confirmDelete = confirm("Are you sure you want to delete this flight?");

    if (confirmDelete === false) {
        return;
    }

    fetch("/flights/delete/"+id,{method: "DELETE"})
    .then(function (response) {
        if (response.ok) {
            alert("Flight deleted successfully");
            loadFlights();
        } else {
            alert("Flight not deleted. Maybe this flight has bookings.");
        }
    })
    .catch(function (error) {
        alert("Delete flight error");
        console.log(error);
    });
}
function loadBookings() {
    fetch("/booking")
        .then(function (response) {
            return response.json();
        })
        .then(function (bookings) {
            var table = document.getElementById("bookingTable");
            table.innerHTML = "";

            for (var i = 0; i < bookings.length; i++) {
                var b = bookings[i];

                var user = b.user_id;
                var flight = b.flight_id;
                var userName = "";
                var userEmail = "";
                var flightNo = "";
                var fromCityName = "";
                var toCityName = "";
                if (user) {
                    userName = user.full_name || "";
                    userEmail = user.email || "";
                }
                if (flight) {
                    flightNo = flight.flight_no || "";
                    var fromCity = flight.fromCity;
                    var toCity = flight.toCity;
                    if (fromCity) {
                        fromCityName = fromCity.city_name || "";
                    }
                    if (toCity) {
                        toCityName = toCity.city_name || "";
                    }
                }
                var row =
                    "<tr>" +
                    "<td>" + b.booking_id + "</td>" +
                    "<td>" + userName + "</td>" +
                    "<td>" + userEmail + "</td>" +
                    "<td>" + flightNo + "</td>" +
                    "<td>" + fromCityName + "</td>" +
                    "<td>" + toCityName + "</td>" +
                    "<td>" + b.travel_date + "</td>" +
                    "<td>" + b.no_of_seats + "</td>" +
                    "<td>" + b.booking_status + "</td>" +
                    "</tr>";
                table.innerHTML = table.innerHTML + row;
            }
            if (table.innerHTML === "") {
                table.innerHTML = "<tr><td colspan='9'>No bookings found</td></tr>";
            }
        })
        .catch(function (error) {
            alert("Bookings not loaded");
            console.log(error);
        });
}
function clearForm() {
    document.getElementById("flightId").value = "";
    document.getElementById("flightNo").value = "";
    document.getElementById("flightName").value = "";
    document.getElementById("fromCityId").value = "";
    document.getElementById("toCityId").value = "";
    document.getElementById("departureDate").value = "";
    document.getElementById("departureTime").value = "";
    document.getElementById("arrivalDate").value = "";
    document.getElementById("arrivalTime").value = "";
    document.getElementById("ticketPrice").value = "";
    document.getElementById("totalSeats").value = "";
    document.getElementById("availableSeats").value = "";
    document.getElementById("adminId").value = "";
}
function logout() {
    window.location.href = "login.html";
}
