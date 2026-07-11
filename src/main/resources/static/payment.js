window.onload = function () {
    loadPaymentInfo();
};

function getValueFromUrl(name) {
    var url = new URL(window.location.href);
    return url.searchParams.get(name);
}

function loadPaymentInfo() {
    var bookingId = getValueFromUrl("bookingId");
    var amount = getValueFromUrl("amount");
    if (bookingId === null || amount === null) {
        alert("Payment information missing");
        window.location.href = "user.html";
        return;
    }
    document.getElementById("bookingId").value = bookingId;
    document.getElementById("amount").value = amount;
}

function makePayment() {
    var bookingId = document.getElementById("bookingId").value;
    var amount = document.getElementById("amount").value;
    var cardHolderName = document.getElementById("cardHolderName").value;
    var cardNumber = document.getElementById("cardNumber").value;
    var expiryDate = document.getElementById("expiryDate").value;

    if (cardHolderName === "" || cardNumber === "" || expiryDate === "") {
        alert("Please fill payment details.");
        return;
    }

    var payment = {
        booking_id: {booking_id: Number(bookingId)},
        card_holder_name: cardHolderName,
        card_number: cardNumber,
        expiry_date: expiryDate,
        amount: Number(amount),
        payment_status: "Paid"
    };

    fetch("/payment/add", {method: "POST",headers: {"Content-Type": "application/json"},
        body: JSON.stringify(payment)
    })
    .then(function (response) {
        if (response.ok) {
            alert("Payment successful. Booking completed.");
            window.location.href = "user.html";
        } else {
            alert("Payment failed");
        }
    })
    .catch(function (error) {
        alert("Payment error");
        console.log(error);
    });
}

function backToFlights() {
    window.location.href = "user.html";
}

function logout() {
    window.location.href = "login.html";
}