// JavaScript Document
function multiplyAndAddFive(value1, value2){
	// summary:  ����value1*value2+5�Ľ����
	//           ����������������number���ͣ�
	//           �������������Ҫ�󣬷���null��
	// return:   ���ؽ����������Number
	
	//���value1��value2������Number���ͣ�ֱ�ӷ���null
	if(typeof value1 !="number") return null ;
	if(typeof value2 !="number") return null ;
	
	var result = value1*value2+5 ;
	return result ;
}