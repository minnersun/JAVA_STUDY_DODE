function Person(name,sex,age){
	this.name = name ;
	this.sex = sex ;
	this.age = age ;
	
	//������ķ������Ѻ�������ֵ��������
	//�������ں�����д����������֮��
	this.walk = walk ;

	this.faster = faster ;

	this.slower = slower ;

	this.stopWalking = stopWalking;
}

//��д������
function walk() {
	this.state = "walking";
	this.speed = 1;
}


function faster(){
	if(this.state == "walking"){
		this.speed = this.speed + 0.1;
	}
}

function slower(){
	if(this.state == "walking"){
		this.speed = this.speed - 0.1;
	}
}

function stopWalking(){
	this.state = "standing";
	this.speed=0;
}