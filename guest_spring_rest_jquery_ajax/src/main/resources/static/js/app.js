import { guest_main } from "./template-guest-main.js";
import { guest_write_form } from "./template-guest-write-form.js";
import { guest_list } from "./template-guest-list.js";
import { guest_view } from "./template-guest-view.js";
import { guest_modify_form } from "./template-guest-modify-form.js";
import { ajaxRequest } from "./request.js";
import {
	GUEST_DETAIL, GUEST_MODIFY_ACTION, GUEST_MODIFY_FORM,
	GUEST_REMOVE_ACTION, GUEST_LIST, GUEST_WRITE_ACTION
} from "./request-url.js";
import { createInitializer} from "./initializer.js";

import {createTest} from "./test.js";
const test = createTest();
test.testa();
test.testb();
test.testc();





let validator=null;

function navigate() {
	const hash = window.location.hash
	const path = hash.substring(1);
	let html = '';
	if (path == '/guest_main') {
		/****************guest_main start******************/
		html = guest_main();
		$('#content').html(html);
	} else if (path == '/guest_list') {
		/****************guest_list start******************/
		let responseJsonObject =
			ajaxRequest(GUEST_LIST.method, GUEST_LIST.url);
		html = guest_list(responseJsonObject);
		$('#content').html(html);
	} else if (path == '/guest_write_form') {
		/****************guest_write_form start************/
		html = guest_write_form();
		$('#content').html(html);
		/*###############################[form validator plugin]##########################
		form validator
		 - HOMEPAGE :   https://jqueryvalidation.org/
		 - API      :   https://jqueryvalidation.org/validate/
			1. $(form).validate() function은 form loading시에 미리 호출되어있어야한다.
			2. var validator=$(form).validate(); 실행후 반환되는 validator 객체를 사용한다.
		#################################################################################*/
		validator = $('#guest_write_form').validate();
		
	} else if (path.startsWith('/guest_view/')) {
		/****************guest_view start*****************/
		const guest_no = path.substring(path.lastIndexOf('/') + 1);
		let responseJsonObject =
			ajaxRequest(GUEST_DETAIL.method, GUEST_DETAIL.url.replace('@guest_no', guest_no));
		html = guest_view(responseJsonObject);
		$('#content').html(html);
	} else if (path.startsWith('/guest_modify_form/')) {
		/****************guest_modify_form start*********/
		const guest_no = path.substring(path.lastIndexOf('/') + 1);
		const responseJsonObject =
			ajaxRequest(GUEST_MODIFY_FORM.method, GUEST_MODIFY_FORM.url.replace('@guest_no', guest_no));
		html = guest_modify_form(responseJsonObject);
		$('#content').html(html);
	} else if (path == '/guest_write_action') {
		    //validation성공하면
		    console.log(">>>/guest_write_action");
		    if(validator.form()){
			/****************guest_write_action start******************/
				let sendJsonObject = {
					guest_no: 0,
					guest_date: "",
					guest_name: document.f.guest_name.value,
					guest_email: document.f.guest_email.value,
					guest_homepage: document.f.guest_homepage.value,
					guest_title: document.f.guest_title.value,
					guest_content: document.f.guest_content.value
				};
				const responseJsonObject =
					ajaxRequest(GUEST_WRITE_ACTION.method, GUEST_WRITE_ACTION.url, sendJsonObject);
				if (responseJsonObject.status == 1) {
					window.location.hash = '/guest_view/' + responseJsonObject.data[0].guest_no;
				} else {
					alert(result.msg);
				}
			}
		
	} else if (path.startsWith('/guest_remove_action/')) {
		/****************guest_remove_action start******************/
		const guest_no = path.substring(path.lastIndexOf('/') + 1);
		const responseJsonObject =
			ajaxRequest(GUEST_REMOVE_ACTION.method, GUEST_REMOVE_ACTION.url.replace("@guest_no", guest_no));
		if (responseJsonObject.status == 1) {
			window.location.hash = '/guest_list';
		} else {
			alert(responseJsonObject.msg);
		}
	} else if (path.startsWith('/guest_modify_action/')) {
		const guest_no = path.substring(path.lastIndexOf('/') + 1);

		let sendJsonObject = {
			guest_no: $("#f [name='guest_no']").val(),
			guest_date: "",
			guest_name: $("#f [name='guest_name']").val(),
			guest_email: $("#f [name='guest_email']").val(),
			guest_homepage: $("#f [name='guest_homepage']").val(),
			guest_title: $("#f [name='guest_title']").val(),
			guest_content: $("#f [name='guest_content']").val()
		};

		const responseJsonObject = ajaxRequest(GUEST_MODIFY_ACTION.method,
			GUEST_MODIFY_ACTION.url.replace("@guest_no", guest_no),
			sendJsonObject);
		window.location.hash = "/guest_view/" + guest_no;
	}else{
		html = guest_main();
		$('#content').html(html);
	}
	


}//navigate
$(window).on('hashchange', navigate);

$(document).on('click', function(e) {
	console.log(e.target.getAttribute('data-navigate'));
	if (e.target.getAttribute('data-navigate')) {
		/*
		해시변경이벤트발생
		*/
		window.location.hash = e.target.getAttribute('data-navigate');
		
		if(e.target.getAttribute('data-navigate')=='/guest_write_action'){
			navigate();
		}
	}
});


/*********jQuery Ajax Global Event ************/
$(document).ajaxStart(function() {
	$("<div id='loading'>loading...</div>").insertBefore('#content');
	$('#loading').fadeToggle(100);
});
$(document).ajaxComplete(function() {
	//$('#loading').hide();

	$('#loading').fadeToggle(400);
	$('#loading').remove();
});

const initializer = createInitializer();
initializer.validatorSetDefault();
initializer.getMessageScript();
initializer.addCustomFunctionHandlebars();
navigate();



/***************************DOMNodeInserted********************************
document.querySelector('#content').addEventListener("DOMNodeInserted",function(e){
	if(document.querySelector('#guest_write_form')){
		//console.log($(e.target).find('#guest_write_form')[0]);
	}
});
*/
/*
$(document).on('DOMNodeInserted','#content',function(e){
	if($(e.target).find('#guest_write_form')[0]){
		console.log($(e.target).find('#guest_write_form')[0]);
	}
	
});
*/
/***************************MutationObserver********************
var observer = new MutationObserver(function(mutations) {
	mutations.forEach(function(mutation) {
		var nodes = Array.prototype.slice.call(mutation.addedNodes);
		nodes.forEach(function(node) {
		   console.log($(node).find('#guest_write_form').validate());
		});
	});
});
observer.observe(document.querySelector("#content"), {
	childList: true,
	subtree: true,
	attributes: false,
	characterData: false,
});
***********************************************************/