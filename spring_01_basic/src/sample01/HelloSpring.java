package sample01;
/*
 * ���յ�
 * 1.Ŭ�������� ��ȣ ���Ἲ ������ �ǹ��Ѵ�.
 * ���� ���յ��� �������� �ϳ��� ��ä ������ �ٸ� ��ü�� ������ ���ļ��� �ȵȴ�.
 * 
 * 
 * 
 */
public class HelloSpring {
public static void main(String[] args) {
//	MessageBeanKorea bean=new MessageBeanKorea();
	//display(bean);
	
	MessageBeanEnglish bean=new MessageBeanEnglish();
	display(bean);
}
public static void display(MessageBeanEnglish bean) {
	bean.sayHello("Spring");
}
}
