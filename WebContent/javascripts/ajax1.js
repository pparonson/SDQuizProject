//A simple AJAX example
    //1 XMLHttpRequest obj
    //2 Create a callback() fn
    //3 Open a request
    //4 Send the request

//Test console.log()
console.log("Inside script tag.");

var xhr = new XMLHttpRequest(); //1 XMLHttpRequest obj
//call back function listening for final change of state
xhr.onreadystatechange = function() { //2 Create a callback() fn
    if (xhr.readyState === 4) {
        document.getElementById('ajax').innerHTML = xhr.responseText;//wiring: <div>ajax</div>
    } //end: if
} // end: fn
xhr.open('GET', 'sidebar.html'); //this fn prepares the browser for sending the request
xhr.send(); //sends request
