package part02;



import model.MemDAO;
import model.MemDTO;

public class ServiceImp implements Service{
	
	
private MemDAO memDAO;

	
public ServiceImp() {
	
}
public void setMemDAO(MemDAO memDAO) {
	this.memDAO=memDAO;
}


@Override
public void insertProcess() {


	memDAO.insertMethod(new MemDTO(49,"������",50,"���"));
	memDAO.insertMethod(new MemDTO(50,"������",20,"����"));

}//end insert


}
