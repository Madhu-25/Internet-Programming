window.onload = function() {
  document.getElementById("table1").style.visibility= "hidden";
  setInterval( function changeTime()
  {
    let clock = document.getElementById("time");
    let currentDate = new Date(Date.now());
    var x = currentDate.getMinutes();
    if(x<10){
      x= "0" + x;

    }
    var s = currentDate.getSeconds();
    if(s<10){
      s= "0" + s;

    }
    clock.innerText = "Time: " + currentDate.getHours() + ":" + x + ":" +s;

  } , 1000);
}

function changeOutline()
{
  var x = document.getElementById("name");
  x.style.outline="2px solid rgb(218, 64, 64)";
}

function changeBackground()
{
  var x = document.getElementById("name");
  x.style.background="lightblue";
}

function returnFocus(x)
{
  
  x.focus();
}

function alertNumber()
{
  var x = document.getElementById("age");
  alert("Cannot type value");
}

function displayStatus()
{
  var x = document.getElementById("status").value;
  document.getElementById("sample").innerHTML = "You have selected: " + x;

}

function alertPhone()
{
  document.getElementById("phone").focus();
  alert("Enter contact number in specified format!");
}

function clearmsg()
{
  alert("Contents have been cleared");
}



function display(){
  
 
  var name = document.getElementById("name").value;
  if(name=="")
  {
    alert("Enter name!!");
    returnFocus(document.getElementById());
  }
  document.getElementById("name1").innerHTML=name;
  
  var address  = document.getElementById("address").value;
  if(address=="")
  {
    alert("address is required!");
    returnFocus();
  }
  document.getElementById("address1").innerHTML=address;
  var age = document.getElementById("age").value;
  if(!age)
  {
    alert("Age is required!");
    returnFocus();
  }
  document.getElementById("age1").innerHTML=age;
  var dob  = new Date(Date.parse(document.reg.dob.value));
  var d = dob.getDate()+ "-"+dob.getMonth()+"-"+dob.getFullYear();
  document.getElementById("dob1").innerHTML=d;
  var status = document.getElementById("status").value;
  document.getElementById("status1").innerHTML=status;
  var contact = document.getElementById("contact").value;
  document.getElementById("contact1").innerHTML=contact;
  var addiction = document.getElementById("addiction").value;
  var gender = document.reg.gender.value;
  if(!gender)
  {
    alert("Please select gender!");
    returnFocus();
  }
  document.getElementById("gender1").innerHTML=gender;
  
  document.getElementById("addiction1").innerHTML=addiction;
  var x = document.getElementById("table1");

  document.getElementById("formdiv").style.visibility = "hidden";
  x.style.background = "rgb(156, 199, 240)";
  x.style.visibility = "visible";
  x.style.position = "absolute" ;
  x.style.top = "30%";
  x.style.marginTop = "30px";

}

document.addEventListener('dragstart', function (event) 
{
      event.dataTransfer.setData('Text', event.target.innerHTML);
});
var form = document.getElementById("reg");
function handleForm(event) { event.preventDefault(); } 
form.addEventListener('submit', handleForm);