var httpRequest=null;

function createHttpRequest(){
	if(window.ActiveXObject){	//IE
		return new ActiveXObject("Msxml2.XMLHTTP");
	}else if(window.XMLHttpRequest){
		return new XMLHttpRequest();	//chrome, ff
	}else{
		alert("지원하지 않는 브라우저입니다.");
		return null;
	}	
	
}

function sendMessage(method,url,param,callback){
	httpRequest=createHttpRequest();
	
	var httpMethod=method;
	var httpUrl=url;
	var httpParam=param;
	
	if(method=="GET" || method==null){
		httpUrl=httpUrl+"?"+httpParam;
	}
	
	httpRequest.open(method,httpUrl,true);
	httpRequest.onreadystatechange=callback;
	httpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	httpRequest.send(method=="GET"||method==null?null:param);
}
















