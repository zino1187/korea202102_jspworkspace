/**
 * 재사용 가능성이 높은 코드는 객체로 정의할 수 있다. 
	2015 ECMA Script 에서부터는 js도 class를 지원!!!
 */
class Comments{
	constructor(){
		//구성요소 생성
		this.div=document.createElement("div");	
		this.t_msg=document.createElement("input"); //default 는 text field
		this.t_cwriter=document.createElement("input");
		this.t_cdate=document.createElement("input");
		
		//스타일적용 
		this.t_msg.style.width=60+"%";
		this.t_msg.readOnly=true;
		this.t_cwriter.style.width=20+"%";	
		this.t_msg.readOnly=true;
		this.t_cdate.style.width=10+"%";
		this.t_cdate.readOnly=true;
		
	}	
}