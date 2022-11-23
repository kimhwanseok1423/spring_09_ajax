package part03;



import org.springframework.transaction.annotation.Transactional;

import model.MemDAO;
import model.MemDTO;

public class ServiceImp implements Service{
	
	
private MemDAO memDAO;

	
public ServiceImp() {
	
}
public void setMemDAO(MemDAO memDAO) {
	this.memDAO=memDAO;
}

@Transactional(rollbackFor = java.lang.Exception.class)
@Override
public void insertProcess() {


	memDAO.insertMethod(new MemDTO(53,"������",50,"���"));
	memDAO.insertMethod(new MemDTO(53,"������",20,"����"));

}//end insert


}
