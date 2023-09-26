function createInitializer() {
	let validator = {};
	const initializer = {
		setValidator:function(v){
			console.log(v);
			validator=v;
		}
		,
		getValidator:function(){
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
		},
		getMessageScript:function(){
			$.getScript(`js/localization/messages_${navigator.language}.js`);
		},
		validatorSetDefault: function() {
			$.validator.setDefaults({
				rules: {
					guest_name: {
						required: true,
						minlength: 2
					},
					guest_email: {
						required: true,
						email: true
					},
					guest_homepage: {
						required: true,
						url: true
					},
					guest_title: {
						required: true,
						rangelength: [3, 6]
					}

				},
				messages: {
					guest_name: {
						required: "이름을 입력하세요",
						minlength: "이름은 {0} 글자이상입니다."
					},
					guest_title: {
						required: "타이틀을 입력하세요",
						rangelength: "타이틀의 글자수는 {0} ~ {1} 사이입니다."
					}

				},
				errorClass: 'error',
				validClass: 'valid'
			});
		}


	}

	return initializer;
}
export {createInitializer};