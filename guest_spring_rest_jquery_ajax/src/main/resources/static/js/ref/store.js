function init(){
	console.log("sdfsdfsdf");
	window.localStorage.setItem('guests',JSON.stringify([]));
	window.localStorage.setItem('guest',JSON.stringify({}));
}
function setGuests(guests){
	window.localStorage.setItem('guests',JSON.stringify(guests));
}
function getGuests(){
	return JSON.parse(window.localStorage.getItem('guests'));
}
function setGuest(guest){
	window.localStorage.setItem('guests',JSON.stringify(guest));
}
function getGuest(){
	return JSON.parse(window.localStorage.getItem('guest'));
}
init();
export { setGuest,getGuest,setGuests,getGuests}