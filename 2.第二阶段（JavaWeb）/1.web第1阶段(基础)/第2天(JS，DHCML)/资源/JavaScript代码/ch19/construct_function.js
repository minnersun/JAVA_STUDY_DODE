// JavaScript Document
function createPerson(name,sex,age){
	// summary:  ����һ��person����
	// String name : person������
	// String sex : person���Ա�
	// String age : ����
	//
	// return: ����һ��person����
	person = new Object();
	person.name = name;
	person.sex = sex;
	person.age = age;

	person.walk = function() {
		person.state = "walking";
		person.speed = 1;
	}

	person.faster = function(){
		if(this.state == "walking"){
			this.speed = this.speed + 0.1;
		}
	}

	person.slower = function(){
		if(this.state == "walking"){
			this.speed = this.speed - 0.1;
		}
	}

	person.stopWalking = function(){
		this.state = "standing";
		this.speed=0;
	}
	
	return person ;
}

function createTeam(name){
	// summary:  ����һ��team����
	// String name : team������
	//
	// return: ����һ��team����
	team = new Object();
	team.name = name;
	team.members = new Array();
	team.leader = new Object();

	team.addMember = function(member){
		//�����thisָ����team����
		this.members.push(member);
	}

	team.count = function(){
		//�����thisָ����team����
		return this.members.length;
	}

    return team ;
}