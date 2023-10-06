function createInitializer() {
	let validator = {};
	
	const initializer = {
		registerAjaxGlobalEvent:function(){
			/*********jQuery Ajax Global Event ************/
			$(document).ajaxStart(function() {
				$("<div id='loading'>loading...</div>").insertBefore('#content');
				$('#loading').show();
			});
			$(document).ajaxComplete(function() {
				$('#loading').hide();
				$('#loading').remove();
			});

		},
		setValidator: function(v) {
			console.log(v);
			validator = v;
		}
		,
		getValidator: function() {
			return validator;
		},
		addCustomFunctionHandlebars: function() {
			/*****Handlebars 함수등록 */
			Handlebars.registerHelper('substring', function(str, start, end) {
				return str.substring(start, end);
			});
			Handlebars.registerHelper('toUpper', function(str) {
				return str.toUpperCase();
			});
			Handlebars.registerHelper('ifCond', function(v1, operator, v2, options) {
				switch (operator) {
					case '==':
						return (v1 == v2) ? options.fn(this) : options.inverse(this);
					case '===':
						return (v1 === v2) ? options.fn(this) : options.inverse(this);
					case '!=':
						return (v1 != v2) ? options.fn(this) : options.inverse(this);
					case '!==':
						return (v1 !== v2) ? options.fn(this) : options.inverse(this);
					case '<':
						return (v1 < v2) ? options.fn(this) : options.inverse(this);
					case '<=':
						return (v1 <= v2) ? options.fn(this) : options.inverse(this);
					case '>':
						return (v1 > v2) ? options.fn(this) : options.inverse(this);
					case '>=':
						return (v1 >= v2) ? options.fn(this) : options.inverse(this);
					case '&&':
						return (v1 && v2) ? options.fn(this) : options.inverse(this);
					case '||':
						return (v1 || v2) ? options.fn(this) : options.inverse(this);
					default:
						return options.inverse(this);
				}
			});

		},
		getMessageScript: function() {
			$.getScript(`js/localization/messages_${navigator.language}.js`);
		},
		validatorSetDefault: function() {
			$.validator.setDefaults({});
		},
		validatorUserWriteFormSetDefault:function(){
			$.validator.setDefaults({
			rules:{
				userId:{
					required:true,
					minlength: 3,
					maxlength: 6,
					remote:{
						url:'user/idcheck',
						type:'GET',
						data:{
							userId:function(){
								return $('#userId').val();
							}
						}
						
					}
				},
				password:{
					required:true,
				},
				password2:{
					required:true,
					equalTo:'#password'
				},
				name:{
					required:true,
				},
				email:{
					required:true,
					email:true
				}
			},
			messages:{
				userId:{
					required:'아이디를 입력하세요',
					minlength:'아이디는 {0}글자이상입니다.',
					maxlength:'아이디는 {0}글자이하입니다.'
				},
				password:{
					required:'패쓰워드를 입력하세요.',
				},
				password2:{
					required:'패쓰워드확인을 입력하세요.',
					equalTo:'패쓰워드와 확인은 일치하여야합니다.'
				},
				name:{
					required:"이름을입력하세요",
				},
				email:{
					required:"이메일을입력하세요",
					email:"이메일형식이 일치하지않습니다."
				}
			},
			errorClass:'error',
			validClass:'valid'
		});	
		}
		

	}

	return initializer;
}
export { createInitializer };