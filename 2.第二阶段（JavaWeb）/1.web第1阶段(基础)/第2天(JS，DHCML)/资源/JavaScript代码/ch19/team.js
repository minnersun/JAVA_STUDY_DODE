team = new Object();
team.name = "demo team";
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

team.leader.name = "leader man";

team.leader.run=function(){
	//�����this ָ����team.leader����
	this.state="running";
}