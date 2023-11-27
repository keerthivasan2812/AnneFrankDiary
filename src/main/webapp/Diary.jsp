<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Diary Entry</title>
</head>
<body>
<form action="Diary" method="post">
<h1>DIARY ENTRY</h1>
<br>
<input id="date" name="date" type="date">
<a href="Diaryv">Click Here To See All DiaryEntries</a>
<br>


<textarea rows="30" cols="200"  name="diary" id="diary"></textarea>
<br>
<br>
<button onclick=" submit(event)">SUBMIT</button>
</form>
<script type="text/javascript">
window.onload=function(){
const d = new Date();
  const formattedDate = d.toISOString().split('T')[0]; 
document.getElementById("date").value = formattedDate; 
};
   
   
   function submit(event){
	   event.preventDefault();
	   
	   const dateinput=document.getElementById("date").value;
	   const diaryinput=document.getElementById("diary").value;
	   if (dateinput!=null&&dateinput!=""&&diaryinput!=null&&diaryinput!="") {
		
	
	   
	   
	   const form =new FormData(document.querySelector('form'));
	   const myrequest=new XMLhttpRequest();
	   
	   myrequest.onload=function(){
		   if (myrequest.status === 200) {
			   
			   console.log(myrequest.responseText);
			
		} else {
			console.log('error:'+myrequest.status);

		}
		   
		   
	   };
	   
	   myrequest.open("Post","Diary",true);
	   
	   myrequest.send(form);
	   
	   
	   
   
   
   
   
   }
   
   else {

	   console.log("!InvalidInput");
	}
   };
   
   </script>
   

</body>
</html>