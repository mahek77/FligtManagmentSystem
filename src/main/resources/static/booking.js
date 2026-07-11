var selectedFlight = null;

window.onload = function(){
loadSelectedFlight();
};

function getValueFromUrl(name){
var url = new URL(window.location.href);
return url.searchParams.get(name);
}

function loadSelectedFlight(){
var flightId = getValueFromUrl("flightId");

if(flightId == null){
alert("No flight selected");
window.location.href = "user.html";
return;
}

fetch("/flights/"+flightId)
.then(function(response) {return response.json();})
.then(function(flight) {
selectedFlight = flight;
var fromCityName= "";
var toCityName="";

if(flight.fromCity){
fromCityName = flight.fromCity.city_name;
}
 if (flight.toCity) {
                toCityName = flight.toCity.city_name;
            }
            var departureDate = flight.departureDate || flight.departure_date || "";
            document.getElementById("flightNo").innerText = flight.flight_no;
            document.getElementById("flightName").innerText = flight.flight_name;
            document.getElementById("fromCity").innerText = fromCityName;
            document.getElementById("toCity").innerText = toCityName;
            document.getElementById("departure").innerText = departureDate + " " + flight.departure_time;
            document.getElementById("ticketPrice").innerText = flight.ticket_price;
            document.getElementById("availableSeats").innerText = flight.available_seats;
            document.getElementById("travelDate").value = departureDate;
        })
        .catch(function (error) {
            alert("Flight not loaded");
            console.log(error);
        });
}

function createBooking() {
    var fullName = document.getElementById("fullName").value;
    var email = document.getElementById("email").value;
    var phoneNo = document.getElementById("phoneNo").value;
    var cnic = document.getElementById("cnic").value;
    var passportNo = document.getElementById("passportNo").value;
    var nationality = document.getElementById("nationality").value;
    var travelDate = document.getElementById("travelDate").value;
    var noOfSeats = document.getElementById("noOfSeats").value;
    if (fullName === "" || email === "" || phoneNo === "" || cnic === "" || nationality === "") {
        alert("Please fill passenger details");
        return;
    }
    if (travelDate === "") {
        alert("Please select travel date");
        return;
    }
    if (noOfSeats === "" || Number(noOfSeats) <= 0) {
        alert("Please enter correct number of seats");
        return;
    }
    if (Number(noOfSeats) > Number(selectedFlight.available_seats)) {
        alert("Not enough seats available");
        return;
    }
    var user = {
        full_name: fullName,
        email: email,
        phone_no: phoneNo,
        cnic: cnic,
        passport_no: passportNo,
        nationality: nationality
    };
    fetch("/users/add", {method: "POST",headers: {"Content-Type": "application/json"},body: JSON.stringify(user)})
    .then(function (response) {
        if (!response.ok) {
            alert("User not saved");
            return null;
        }
        return response.json();
    })
    .then(function (savedUser) {
        if (savedUser == null) {
            return null;
        }
        var booking = {
            user_id: {user_id: savedUser.user_id},
            flight_id: {flight_id: selectedFlight.flight_id },
            travel_date: travelDate,
            no_of_seats: Number(noOfSeats),
            booking_status: "Booked"
        };

        return fetch("/booking/add", {method: "POST",headers: {"Content-Type": "application/json"},body: JSON.stringify(booking)});
        })
    .then(function (response) {
        if (response == null) {
            return null;
        }
        if (!response.ok) {
            alert("Booking failed");
            return null;
        }
        return response.json();
    })
    .then(function (savedBooking) {
        if (savedBooking == null) {
            return;
        }
        var totalAmount = Number(selectedFlight.ticket_price) * Number(noOfSeats);
        alert("Booking created successfully. Now make payment.");
        window.location.href =
            "payment.html?bookingId=" + savedBooking.booking_id + "&amount=" + totalAmount;
    })
    .catch(function (error) {
        alert("Booking error");
        console.log(error);
    });
}
function backToFlights() {
    window.location.href = "user.html";
}

function logout() {
    window.location.href = "login.html";
}