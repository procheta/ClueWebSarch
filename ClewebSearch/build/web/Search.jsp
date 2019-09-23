<%-- 
    Document   : Search
    Created on : 23-Sep-2019, 11:43:48
    Author     : Procheta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clueweb Search Interface</title>
        <link rel="stylesheet" href="displayres.css" />
        <script src="jquery/spin.js"></script>
        <script>
        var opts = {
          lines: 13 // The number of lines to draw
        , length: 28 // The length of each line
        , width: 14 // The line thickness
        , radius: 42 // The radius of the inner circle
        , scale: 1 // Scales overall size of the spinner
        , corners: 1 // Corner roundness (0..1)
        , color: '#000' // #rgb or #rrggbb or array of colors
        , opacity: 0.25 // Opacity of the lines
        , rotate: 0 // The rotation offset
        , direction: 1 // 1: clockwise, -1: counterclockwise
        , speed: 1 // Rounds per second
        , trail: 60 // Afterglow percentage
        , fps: 20 // Frames per second when using setTimeout() as a fallback for CSS
        , zIndex: 2e9 // The z-index (defaults to 2000000000)
        , className: 'spinner' // The CSS class to assign to the spinner
        , top: '50%' // Top position relative to parent
        , left: '50%' // Left position relative to parent
        , shadow: false // Whether to render a shadow
        , hwaccel: false // Whether to use hardware acceleration
        , position: 'absolute' // Element positioning
        };
        var spinner;
        
        function isNumeric(n) {
            return !isNaN(parseFloat(n)) && isFinite(n);
        }
        
        function retrieveAdhoc() {
            var qtext = document.getElementById("query").value;
            if (qtext.length == 0) {
                document.getElementById("query").focus();
                return;
            }
                
           // var simf = document.getElementById("simf").value;
           // var nwanted = document.getElementById("numwanted").value;
            
            var xmlhttp;
            if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp=new XMLHttpRequest();
            }
            else {// code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange = function() {
                spinner.stop();
                if (xmlhttp.readyState==4 && xmlhttp.status==200) {
                    document.getElementById("srchres").innerHTML = xmlhttp.responseText;
                }
            }

            var k = 1;
            var b = 1;
                        
                        
            var req = "SearchServlet?query=" + qtext ;
            
            xmlhttp.open("GET", req, true);
            xmlhttp.send();
            var target = document.getElementById('containerdiv');
            spinner = new Spinner(opts).spin(target);
            target.appendChild(spinner.el);
        }
        
       

        </script>
    </head>
    <body>
    <center>
    <div id="containerdiv">        
        <img src="images/adapt_logo.png" alt="ADAPT Centre, DCU"
             border="0" style="max-width: 400px; max-height:100px;">
        <br>
        <div>
            <input type="text" id="query" name="query" size="50">
            <input type="button" value="Search" onclick="retrieveAdhoc()"/>
        </div>
        <br>

    </div>
    </center>
    <div id="srchres" name="srchres"></div>         
    </body>
</html>
