/**
* һ���û������࣬�����ֻ��һ����ʾ������
* Ϊ�˼򵥻�����������û��ಢû�а���̫������Ժͷ�����
* ��һ����ʵ����Ŀ�У����������û��࣬���в��ٵ����Ժͷ�����
* ���������еķ�������Ҫ���������Ĳ��ԣ�
* ��֤��Щ�����ǿ�����ȷִ�еģ����ܹ��õ���ȷ�Ľ���ġ�
**/
function User(id,name){
	this.name=name;
	this.id=id;
	this.email = "";
	this.phone = "";
	this.age = 0;
	
	this.EMAIL_WRONG_FORMAT=0;
	this.EMAIL_WRONG_HOST=-1;
	this.EMAIL_CORRECT=1
}

User.prototype.setEmail=function (email){
	// summary:  �����û���email��
	//           �����email��ַ�����Ǿ�����֤�ģ�
	
	this.email=email ;
}

User.prototype.getEmail=function (){
	// summary:  ��ȡ�û���Email��ַ
	//           ��Ȼ����ͨ��email ����ֱ�ӻ��email��ַ
	//           �����������Ĺ淶��������get��������ȡ���ԱȽϺ�
	// return String ��
	//           �����û������email��ַ���������û���������һ��Ĭ��Email��ַ
	
	if(this.email==""){
		return this.name+"@"+"smartdio.com";
	}
	return this.email ;
		
}
User.prototype.checkEmail=function(email){
	// summary�� У��email��ַ�Ƿ���ȷ��
	// return int:
	//           ���email���Ϲ淶��������EMAIL_CORRECT������
	//           email��ʽ����ȷ�����أ�
	//                            EMAIL_WRONG_HOST
	//                            EMAIL_WRONG_FORMAT
	
	var emailPat=/^(.+)@(.+)$/;
	var matchArray=email.match(emailPat);
	if (matchArray==null){
		return this.EMAIL_WRONG_FORMAT;
	}
	if (email.indexOf(" ")>-1){
		return this.EMAIL_WRONG_FORMAT;
	}
	// ���ӶԷ��������ж�
	var host="smartdio.com";
	if (email.length<(host.length+2)){
		return this.EMAIL_WRONG_HOST;
	}
	var num1=email.length-host.length ;
	
	if(email.substr(num1,email.length)!=host){
		return this.EMAIL_WRONG_HOST;
	}
	
	return this.EMAIL_CORRECT;
}
// ...... ��ʵ�У�User �໹�и��෽��������