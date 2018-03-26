$(document).ready(function(){ 
	
	$("#btn1").click(function(){					
		$("#myTitle").text("Changed text");		// Change title
	});
	
	$("#btn2").click(function(){					// Change div1
		$("#div1").text("changed text");
	});
	
    $("#btn3").click(function(){
        $("#div1").text(function(_, origText){ 	// Add new text to the original text
            return origText + " New text"; 
        });
    });
	
	$("#btn4").click(function(){					// Change title
		document.title = "Changed web title"
	});
	
	$("#btn5").click(function(){					// Toggle hidden and showed
		$("#div1").toggle();
	});
});