/**
 *  서버요청  URL
 */
/*
GET /guests
GET /guests/1
POST/guests
DELETE /guests/1
GET /guests/1/edit
PUT /guests/1
*/
const GUEST_LIST={method:'GET',url:"guests"};
const GUEST_DETAIL={method:'GET',url:"guests/@guest_no"};
const GUEST_WRITE_ACTION={method:'POST',url:"guests"};
const GUEST_MODIFY_FORM={method:'GET',url:"guests/@guest_no"};
const GUEST_MODIFY_ACTION={method:'PUT',url:"guests/@guest_no"};
const GUEST_REMOVE_ACTION={method:'DELETE',url:"guests/@guest_no"};

export{GUEST_DETAIL,
		GUEST_LIST,
		GUEST_MODIFY_ACTION,
		GUEST_MODIFY_FORM,
		GUEST_REMOVE_ACTION,
		GUEST_WRITE_ACTION}