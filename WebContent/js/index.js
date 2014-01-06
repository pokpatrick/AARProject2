$(function() {
  $('.error').hide();
  $('input.text-input').css({backgroundColor:"#FFFFFF"});
  $('input.text-input').focus(function(){
    $(this).css({backgroundColor:"#FFDDAA"});
  });
  $('input.text-input').blur(function(){
    $(this).css({backgroundColor:"#FFFFFF"});
  });

  $(".button").click(function() {
		// validate and process form
		// first hide any error messages
    $('.error').hide();
		
	  var name = $("input#name").val();
		if (name == "") {
      $("label#name_error").show();
      $("input#name").focus();
      return false;
    }
		var city = $("input#city").val();
		if (city == "") {
      $("label#city_error").show();
      $("input#city").focus();
      return false;
    }
		var wish = $("input#wish").val();
		if (wish == "") {
      $("label#wish_error").show();
      $("input#wish").focus();
      return false;
    }
		var dataString = 'name='+ name + '&city=' + city + '&wish=' + wish;
		//alert (dataString);return false;
		
		$.ajax({
      type: "POST",
      url: "http://localhost:8080/AARProject2/Christmas/Children/" + name + "/" + city + "/" + wish + "/",
      data: dataString,
      complete: function() {
        $('#contact_form').html("<div id='message'></div>");
        $('#message').html("<h2>Merry Christmas ! ! !</h2>")
        .append("<p>We will be in touch soon.</p>")
        .hide().fadeIn(1500, function() {
          $('#message');
        });
      }
     });
    return false;
	});
});
runOnLoad(function(){
  $("input#name").select().focus();
});
