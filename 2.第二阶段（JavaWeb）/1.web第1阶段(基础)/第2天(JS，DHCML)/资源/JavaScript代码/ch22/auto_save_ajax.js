http_request = null ;
//����AJAX����ĺ���
function createAjax(){
	if (window.XMLHttpRequest) { // Mozilla, Safari,
	    http_request = new XMLHttpRequest();
	    if(http_request.overrideMimeType){
		     http_request.overrideMimeType('text/xml');
	    }
      } else if (window.ActiveXObject) { // IE
	    try {
		     http_request = new ActiveXObject("Msxml2.XMLHTTP");
	    } catch (e) {
		    try {
			     http_request = new ActiveXObject("Microsoft.XMLHTTP");
		    } catch (e) {
				alert("exception");
			}
	    }
      }
}

//��װ���Զ����湦�ܵ���
function AutoSaver( formid,time){
  this.formid = formid;
  this.form=document.getElementById(formid);
  this.time = time;
  this.targetUrl = "./hid_saved2.html";  
 
  
  this.postAutoSave=function(){//post auto saved data
    createAjax();
	http_request.onreadystatechange = this.onReceived;
	http_request.open("GET", this.targetUrl, true);
	//��Ҫ�Լ��������͵�����
	var title = this.__getField("title");
	var content = this.__getField("content");
	var sendData = "title="+title+"&content="+content ;
	//���ͱ�������
	http_request.send(sendData);

  }

 this.__getField= function(fieldName) {  
    for (var e = 0; e < this.form.elements.length; e++){
      if (this.form.elements[e].name == fieldName)
        return this.form.elements[e];
        if (this.form.elements[e].id == fieldName)
        return this.form.elements[e];
     }
  return null;
  }  
    
  this.onReceived=function(){
     if (http_request.readyState == 4) { 
		// һ�о�������������Ӧ
		// ���������ѽ������
		if (http_request.status == 200 || http_request.status == 0) { 
			// �ɹ�������ݣ�
			var requestContent = http_request.responseText ;
			alert(requestContent);
		}else if(http_request.status == 404 || http_request.status == 2){
		    alert("404(Not Found)��δ�ҵ�������ļ�");
		}else { 
			alert("�������ݹ��̳��ִ���!("+http_request.status+")");
		}
	} else {
       //��δ����
	}

  }
  
  
	
}
var __secCounter = null;
var __auto_save_minue = 1;
var autoSaver ;
//time : minue
function startCount(start){
	if(!start)autoSaver.postAutoSave();
 __secCounter = setTimeout("startCount(false)", __auto_save_minue*60*1000);
}