/**
 * 
 */
function createTest(){
	let dataa='KIM';
	let datab=[];
	let datac={};
	const test ={
		testa:function(){
			console.log(dataa);
		},
		testb:function(){
			console.log(datab);
		},
		testc:function(){
			datac={};
		}
	}
	return test;
}

export {createTest};