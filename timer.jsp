<html>
<head>
<script language="javascript">
var Timer;
var TotalSeconds;

function CreateTimer(TimerID, Time) 
{
    Timer = document.getElementById(TimerID);
    TotalSeconds = Time;
    UpdateTimer()
    window.setTimeout("Tick()", 1000);
}

function Tick() 
{
    TotalSeconds -= 1;
    if(TotalSeconds ==-1)
      {
    alert("Time Up");
    window.location="index.jsp";   
      }
   else
     {
    UpdateTimer()
    window.setTimeout("Tick()", 1000);
     }
}

function UpdateTimer() {
    Timer.innerHTML = TotalSeconds;
}
</script>
</head>
<body>
<div id='timer' />

<script type="text/javascript">window.onload = CreateTimer("timer", 30);</script>
</body>
</html>