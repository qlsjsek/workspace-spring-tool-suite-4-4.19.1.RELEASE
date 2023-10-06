/**
 *  서버요청  URL
 */
/*
/*
POST 	/user/login 		- login  user 
GET   	/user/logout		- logout user 
POST 	/user 				- create user 
PUT 	/user/{id} 			- modify user by {id}
GET 	/user/{id} 			- GETs the details of the user with {id}
DELETE 	/user/{id} 			- Delete the user with id 
*/

export  const USER_WRITE_ACTION = { method: 'POST', url: 'user' };
export  const USER_LOGIN_ACTION = { method: 'POST', url: 'user/login' };
export  const USER_LOGOUT_ACTION = { method: 'GET', url: 'user/logout' };
export  const USER_VIEW = { method: 'GET', url: 'user/@userId' };
export  const USER_MODIFY_ACTION = { method: 'PUT', url: 'user/@userId' };
export  const USER_DELETE_ACTION = { method: 'DELETE', url: 'user/@userId' };






