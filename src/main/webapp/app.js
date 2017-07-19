/**
 * app.js
 */

window.onload = function(){
	console.log("HTML loaded")
	loadNavbar();
	loadDashboardView();
}

function loadNavbar(){
	//make an AJAX request to load the navbar html
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log('loading navbar code');
			document.getElementById('navbar').innerHTML = xhr.responseText;
			document.getElementById('txView').addEventListener('click', withdrawDeposit, false);
			document.getElementById('dashboardView').addEventListener('click', loadDashboardView, false);
		}
	}
	
	xhr.open("GET", 'getNavbar', true); // true : asynchronize
	xhr.send();
}

function loadDashboardView(){
	//make an AJAX request to load the dashboard
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log('loading dashbaord code');
			document.getElementById('view').innerHTML = xhr.responseText;
		}
	}
	
	xhr.open("GET", 'getDashboardView', true); // true : asynchronize
	xhr.send();
}

function withdrawDeposit(){
	//make an AJAX request to load the withdraw/deposit
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log('loading withdraw/deposit code');
			document.getElementById('view').innerHTML = xhr.responseText;
			document.getElementById('txBtn').addEventListener("click",processTx, false)
		}
	}
	
	xhr.open("GET", 'getTxView', true); // true : asynchronize
	xhr.send();
}

function processTx(){
	var amount = document.getElementById('amount').value;
	console.log("Amount to process: " + amount);
	var txType = document.querySelector('input[name = "txType"]:checked').value;
	console.log("Type of transaction: " + txType);
	
	//convert values into single JS obj
	var tx = {
			txAmount : amount,
			txType : txType
	}
	
	//convert JavaScript Object into JSON
	tx = JSON.stringify(tx);
	
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
		}
	}
	
	xhr.open("POST", "ajaxProcessTx", true); // true : asynchronize
	console.log(tx);
	
	//set the header to tell the server you have data for it to process
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(tx); //include your post data in the send()
}