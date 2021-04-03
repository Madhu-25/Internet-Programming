window.onload = function() {
  document.getElementById("table1").style.visibility= "hidden";
  document.getElementById("table2").style.visibility="hidden";
  
}

function display1()
{
    document.getElementById("table2").style.visibility="hidden";
    document.getElementById("table1").style.visibility="visible";


}

function display2()
{
    document.getElementById("table1").style.visibility="hidden";
    document.getElementById("table2").style.visibility="visible";
    
    
    document.getElementById("table2").style.position="relative";
    document.getElementById("table2").style.top="-200px";
    document.getElementById("table2").style.left="30px";
    


    
    

}