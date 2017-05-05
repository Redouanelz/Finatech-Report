var root =  document.location.hostname;



/* ouvrire login & register */
function loginOpen()
{
    $("#loginOpen").addClass('open');
}
function registerOpen()
{
    $("#registerOpen").addClass('open');
}


  /* unseen_notifs seeting all notifications to seen. */
  $("#notifs_dropdown").on('click',function(event){
    event.preventDefault();
    var form = $(this);
    var data = form.serialize();
    $.ajax({
      success: function(){
        $("#reload_notifs").load("/ajax/ajax_unseen_notifs.php",data);
      }
    })
  });


/* partager une annonce */
$(document).ready(function(){
    $('#share_annonce_open').hide();
})
$('#share_annonce').on('click',function(){
  $('#share_annonce_open').fadeToggle();
});

$('#messages_dropdown').on('click',function(){
    $('#reload_messages').load('/inc_parts/messages-list.php');
});

$('#notifs_dropdown').on('click',function(){
  $('#reload_notifs').load('/inc_parts/notifs-list.php');
});



/* reload messages refresh */
unseen();
var timeout = setInterval(unseen, 50000);
function unseen () {
     $('#unseen_convo').load('/inc_parts/unseen_convo.php');
     $('#unseen_notifs').load('/inc_parts/unseen_notifs.php');
}
