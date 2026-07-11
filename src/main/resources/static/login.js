function logic(){
var username = document.getElementById("username").value;
var password = document.getElementById("password").value;

if(username===""||password===""){
alert("Please enter username and password");
return;
}
fetch("/login?username=" + username + "&password=" + password, {
    method: "POST"
})
.then(function(response) {
if(response.ok){
return response.json();
}else{
alert("Invalid username or password");
}
})
.then(function(data) {
if(!data){
return;
}
if(data.role==="ADMIN" || data.role === "admin"){
window.location.href = "admin.html";
}else if(data.role==="USER" || data.role ==="user"){
window.location.href ="user.html";
}else{
alert("Invalid role");
}
})
.catch(function(error) {
alert("Login failed");
console.log(error);
});
}