var login_error_clicked = false;
var lang;
var dataformat;
$(function(){
	lang = $('body').attr("lang");
	dataformat = $('body').attr("data-format");
		if($("#lpz_city").length){
			initCityList();
			//showLPZEdit();
			$("#lpz_region").change(function(){
				getCityList();
			});
			$("#lpz_city").change(function(){
				getLPXList();
			});
			$("#new_lpz").change(function(){
				showLPZEdit();
			});
		}
	  	$('#langs-list').mouseenter(function(){
	  		$('#langs-menu').show(1);
	  	});
	  	
	  	$('#langs-menu').mouseleave(function(){
	  		$('#langs-menu').hide();
	  	});
	  	if($("#intro_login").length>0){
	  		initLoginForm();
	  	}else{
	  		$('#intro_login_form_submiter').click(function(){window.location="/sys"});
	  	}
	  	if($.datepicker){
			if($.datepicker.regional[lang])
			  $.datepicker.setDefaults(
		        $.extend($.datepicker.regional[lang])
			  );
			if(lang=="en")
			  $.datepicker.setDefaults({altFormat:'yy-dd-mm',dateFormat:'yy-dd-mm'} );
			else
				  $.datepicker.setDefaults({altFormat:'dd.mm.yy',dateFormat:'dd.mm.yy'} );
			
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
		}
   })
   
function initLoginForm(){
  	if($("#intro_login").val()=="")
		$("#intro_login").val($("#intro_login").attr('jq-placeholder'));
	  	if($("#intro_pwd").val()==""){
			$("#intro_pwd2").val($("#intro_pwd2").attr('jq-placeholder'));
  		}else{
			$("#intro_pwd2").hide();
			$("#intro_pwd").show();
  			
  		}
		
		$("#intro_login").focus(function() 
		{
			if($(this).val() == $(this).attr('jq-placeholder'))
				$(this).val('');
		});
		
		$("#intro_login").blur(function() 
		{
			if($(this).val() == '')
				$(this).val($(this).attr('jq-placeholder'));
		});
		
		$("#intro_pwd2").focus(function() 
		{
			$(this).hide();
			$("#intro_pwd").show();
			$("#intro_pwd").focus();
		});
		
		$("#intro_pwd").blur(function() 
		{
			if($(this).val() == '')
			{
				$(this).hide();
				$("#intro_pwd2").show();
			}
		});
		$('#intro_login_form_submiter').one('click',click_intro_login);
		$('#intro_login_form').ajaxForm(click_intro_login);
		$("#login-error").click(function() 
			{
				login_error_clicked = true;
			});
			$("#main").click(function() 
			{
				if (!login_error_clicked)
					jQuery("#login-error").hide();
				login_error_clicked = false;
			});

}   
function click_intro_login()
  	{
					$('#intro_login_form_submiter').hide();
					$('#intro_form_spinner').show();
					$('#intro_login_form').ajaxSubmit(login_intro);
					return false;
	}   
function login_intro(date){
	if(date=='ok'){
		window.location="/sys";
	}else{
		$("#intro_login").addClass('error');
		$("#intro_pwd").addClass('error');
		
		$("#login-error").show();
		$('#intro_login_form_submiter').show();
		$('#intro_form_spinner').hide();
		$("#intro_login").select();
		
		$('#intro_login_form_submiter').one('click',click_intro_login);

	}
}
function initCityList(){
	if($("#lpz_city option").length<=1){
		getCityList();
	}else if($("#lpz  option").length<=1){
		getLPXList();
	}
}
function getCityList(){
	var region_id=$("#lpz_region").val();
	if(region_id>0){
		$.get("/lookup/city",{region_id:region_id},
			   function(data){
				   var list = '<option value="">'+i18n('site.select')+"</option>";
				   for(var i=0;i<data.length;i++){
					   list += '<option value="'+data[i].id+'">'+data[i].name+"</option>";
				   }
					$("#lpz_city").html(list);
			   }, "json");
	}else{
		$("#lpz_city").html('');
	}
}
function getLPXList(){
	var city_id=$("#lpz_city").val();
	if(city_id>0){
	$.get("/lookup/lpz",{city_id:city_id},
			   function(data){
				   var list = '<option value="">'+i18n('site.select')+"</option>";
				   for(var i=0;i<data.length;i++){
					   list += '<option value="'+data[i].id+'">'+data[i].name+"</option>";
				   }
					$("#lpz").html(list);
			   }, "json");
	}else{
		$("#lpz").html('');
	}
}
function showLPZEdit(){
	var new_lpz = $("#new_lpz").attr("checked");
	if(new_lpz){
		$("#lpz_name").show();
		$("#lpz_select").hide();
	}else{
		$("#lpz_name").hide();
		$("#lpz_select").show();
	}
}
