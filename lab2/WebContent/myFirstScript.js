
function validateMyForm(){
	
	var a=document.forms["userForm"]["firstName"].value;
    var b=document.forms["userForm"]["lastName"].value;
    var c=document.forms["userForm"]["birthDay"].value;
    var d=document.forms["userForm"]["sex"].value;
 
    if (a==null || a=="" || b==null || b=="" || c==null || c=="")
    {
    		var miss = "";
    		if (a==null || a==""){
    			miss = "firstName ";
    		}
    		if (b==null || b==""){
    			miss = miss + "lastName ";
    		}
    		if (c==null || c==""){
    			miss = miss + "birthDay ";
    		}
        alert("You have missed to asdfasdf fill in " + miss);
        return false;
    }
    else {
    	alert("Welcome " + a + " " + b + " Born: " + c + " sex: " + d);
    }
}

function toggleFM(){
	var myButtons = document.querySelectorAll(".type1");
	var myDiv = document.querySelectorAll("fieldset");
	var myHeaders = document.querySelectorAll("legend");
	var theHeader = document.getElementsByTagName("h1");
	
	
	document.getElementById("femaleButton").onclick = function(){
		document.getElementById("h1").innerHTML = "Hello madame";
		for(var i = 0; i < myButtons.length; i++) {
			myButtons[i].style.borderColor = "blue";
			myButtons[i].style.backgroundColor = "lightblue";
		}
		for(var i = 0; i < myDiv.length; i++) {
			myDiv[i].style.borderColor = "blue";
			myDiv[i].style.color = "blue";
		}
		for(var i = 0; i < myHeaders.length; i++) {
			myHeaders[i].style.color = "blue";
		}
		
			 };
	document.getElementById("maleButton").onclick = function(){
		document.getElementById("h1").innerHTML = "Hello sir";
		for(var i = 0; i < myButtons.length; i++) {
			myButtons[i].style.borderColor = "red";
			myButtons[i].style.backgroundColor = "rgba(255, 99, 71, 0.5)";
		}
		for(var i = 0; i < myDiv.length; i++) {
			myDiv[i].style.borderColor = "red";
			myDiv[i].style.color = "red";
		}
		for(var i = 0; i < myHeaders.length; i++) {
			myHeaders[i].style.color = "red";
		}
						
			};
	
	
}
