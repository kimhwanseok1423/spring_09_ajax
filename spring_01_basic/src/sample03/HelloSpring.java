package sample03;
/*
 *factory�� �̿��ϸ� ���յ��� �������̽����ٴ� ���յ��� ������ 
 * factory�� ��Ȯ�� �������� ������ �����ϴ� ��ü�� ������ ����.
 */
public class HelloSpring {

	public static void main(String[] args) {
		MessageBean bean=null;
	//	bean=MessageFactory.getInstance("ko");
	//	display(bean,"������");
		bean=MessageFactory.getInstance("en");
		display(bean,"Spring");
		//display(bean,"Spring");
	}
public static void display(MessageBean bean,String subject) {
	bean.sayHello(subject);

	
}
}
