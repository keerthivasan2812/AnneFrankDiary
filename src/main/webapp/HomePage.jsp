<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
.image-container{
text-align:center;
color:purple;

}

#quote-container {
    position: absolute;
    top: 0;
    right: 50px; /* Adjust this value to move the quote slightly to the left */
    text-align: right;
    font-style: italic;
    font-size: 48px; /* Adjust this value for your desired font size */
    margin: 0;
    padding: 10px; /* Adjust this value as needed */
    }
    .i{
    font-size:120px;
    
    
    
    }

</style>

<title>HOME PAGE</title>
</head>
<body>

<img alt="AnneFrank" src="img/annefrank.jpg" width="1000" height="500" >
<div id="quote-container">
<p id="p"><span class="i">&ldquo;</span>I can shake off <br>everything as I write;<br> my sorrows disappear,<br> my courage is reborn.<br>
&mdash; Anne Frank<span class="i"> &rdquo;</span></p>
 </div>
                    
<p><b>This is a Diary Web-Application that I created to write diary entries about my day-to-day life.
 I created this Application inspired by reading Anne Frank's diary. 
 "Annelies Marie Frank was a German-born Jewish girl who kept a diary in which she documented life in hiding under Nazi persecution. 
 She is a celebrated diarist who described everyday life from her family's hiding place in an Amsterdam attic".
  It is really fascinating to think that a Diary written by a teenage girl is still relevant to this day. </b>
  </p>
  <br>
  <div class="image-container">
<pre><b>Click the</b> </pre>&nbsp;<a href="Diary.jsp"><img alt="My Diary" src="img/diary.png" height="100" width="100"></a>&nbsp;<pre><b> to open Diary.</b></pre>
 </div>
</body>
</html>