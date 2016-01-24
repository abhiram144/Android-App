var Bridge = {};
var BRIDGE_KEY = 'Success';

Bridge.login = function(state){

     //build json string

     var message = {method:"login", state:state}

     prompt(BRIDGE_KEY, JSON.stringify(message));

}
Bridge.callBack = function(result){

     if(result.success){

          alert("login success");

     }

}
   function login(){
		Android.showToast("Hello WOW");
	 }