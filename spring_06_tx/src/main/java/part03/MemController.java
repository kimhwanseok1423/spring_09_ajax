package part03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// http://localhost:8090/myapp/threemain.se
@Controller
public class MemController {

	
	private Service svc;
	
	public MemController() {
		
	}
	
	public void setSvc(Service svc) {
		this.svc=svc;
	}
	@RequestMapping("/threemain.se")
	public void execute() {
		System.out.println("execute");
		//Ʈ�������� ������ �޼ҵ忡���� try-cate���� �Ѥ�.
		
		
		try { 
		svc.insertProcess();
		System.out.println("result: OK");
		}catch(Exception ex) {
			System.out.println("result:"+ex.toString());
		}
	}
}
