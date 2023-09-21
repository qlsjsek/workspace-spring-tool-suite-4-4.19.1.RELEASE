window.jQuery=function(arg){
	if(typeof arg=='string'){
		/*************css selector start**********/	
		let elementNodeList=document.querySelectorAll(arg);
		if(!elementNodeList) elementNodeList=[];		
		
		/*************css selector end**********/	
		let jqueryWrapperObject={
			'elementNodeList':elementNodeList,
			'css':function(propertyName,propertyValue){
				for(let i=0;i<this.elementNodeList.length;i++){
					this.elementNodeList[i].style.cssText=`${propertyName}:${propertyValue}`;
				}
				return this;
			},
			'text':function(textArg){
				if(textArg != undefined){
					//set text
					for(let i=0;i<this.elementNodeList.length;i++){
						this.elementNodeList[i].innerHTML=textArg;
					}
					return this;
				}else{
					//get text
					let returnText="";
					for(let i=0;i<this.elementNodeList.length;i++){
						returnText+=this.elementNodeList[i].innerHTML;
					}
					return returnText;
				}
			}
		};
		
		return jqueryWrapperObject;
	
	
	
	}else if(typeof arg=='function'){
		/*
		인자로 대입된 함수를 DOM트리생성직후에 호출되도록 window.onload이벤트프로퍼티에 등록
		*/
		window.addEventListener('load',arg);
	}else if(typeof arg=='object'){
		
		
	}
}
window.$=window.jQuery;
/******Jquery[$] global function*******/
jQuery.each=function(array,funcArg){
	for(let i=0;i<array.length;i++){
		funcArg(i,array[i]);
	}
};

window.$=window.jQuery;








