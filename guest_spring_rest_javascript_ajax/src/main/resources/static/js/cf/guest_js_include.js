
function addJavaScript(jsFilePath){
	var headElement = document.getElementsByTagName('head')[0];
	var newScriptElement = document.createElement('script');
	newScriptElement.setAttribute('type','text/javascript');
	newScriptElement.setAttribute('src',jsFilePath);
	headElement.appendChild(newScriptElement);
}
addJavaScript('js/app.js');
addJavaScript('js/request.js');
addJavaScript('js/request-url.js');

