  $(function(){
	  
  $.datepicker.setDefaults(
        $.extend($.datepicker.regional["ru"],{dateFormat:"dd.mm.y"})
	  );
	  
   $(".forpicker").datepicker(
		   {showOn: "button",
			buttonImage: "/public/images/calendar.gif",
			buttonImageOnly: true
		   }
	);
   $(".forpicker_dob").datepicker(
		   {maxDate:"0d",
		   showOn: "button",
			buttonImage: "/public/images/calendar.gif",
			buttonImageOnly: true
		   }
	);
   
   $(".forpicker_cons_dob").datepicker(
		   {maxDate:"-20y",
		   showOn: "button",
			buttonImage: "/public/images/calendar.gif",
			buttonImageOnly: true
		   }
	);
   
   })