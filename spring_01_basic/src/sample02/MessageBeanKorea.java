package sample02;

public class MessageBeanKorea implements MessageBean{
	
	public MessageBeanKorea() {
		
	}

	@Override
	public void sayHello(String name) {
		System.out.printf("�ȳ�,%s !!!",name);
		
	}

}
