package controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.MemDAO;
import dto.MemDTO;



// http://localhost:8090/myapp/mem/list

//@RestController=@controller+ @ResponseBody
//@CrossOrigin("*")   //로컬호스트 번호가 달라도 실행하면 허용가능 
//CrossOrigin("http://localhost:30000")

//@RestController
@Controller
public class MemController {
private MemDAO dao;

public MemController() {
	
}


public void setDao(MemDAO dao) {
	this.dao = dao;
}
@ResponseBody
@RequestMapping(value="/list",method=RequestMethod.GET)
public List<MemDTO> listMethod(){
	System.out.println("list");
	return dao.list();
}
  //18번 테이블에 있는 값 가져오기
// http://localhost:8090/myapp/mem/list/18
@ResponseBody
@RequestMapping(value="/list/{ss}",method=RequestMethod.GET)
public MemDTO listMethod(@PathVariable("ss") int num) {
	return dao.list(num);
}

//  http://localhost:8090/myapp/mem/list/18/홍재수
@ResponseBody
@RequestMapping(value="/list/{ss}/{name}",method=RequestMethod.GET)
public MemDTO listMethod(@PathVariable("ss") int num,@PathVariable("name") String name) {
	return dao.list(new MemDTO(num,name));
}

//삽입시키기 


// {"name":"홍길동","age":30, "loc":"서울"}    --> postmen에서 넣기 (캡처했음 확인하면서 복습하기)
// http://localhost:8090/myapp/mem/insert
@RequestMapping(value="/insert",method=RequestMethod.POST)
public ResponseEntity<String> insertMethod(@RequestBody MemDTO dto){
ResponseEntity<String> entity=null;
try {
dao.register(dto);
entity=new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
}catch(Exception e ) {
	entity=new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
}
return entity;
}


//업데이트
// {"num" :48, "name":"Steven"}
//http://localhost:8090/myapp/mem/update
@RequestMapping(value="/update",method=RequestMethod.PUT)  //업데이트는 put으로하기 
public ResponseEntity<String> updateMethod(@RequestBody MemDTO dto){
ResponseEntity<String> entity=null;
try {
dao.update(dto);
entity=new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
}catch(Exception e ) {
	entity=new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
}
return entity;
}


//삭제하기

//http://localhost:8090/myapp/mem/delete/48
@RequestMapping(value="/delete/{num}",method=RequestMethod.DELETE)  //삭제하기는 DELETE으로하기 
public ResponseEntity<String> deleteMethod(@PathVariable("num") int num){
ResponseEntity<String> entity=null;
try {
dao.delete(num);
entity=new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
}catch(Exception e ) {
	entity=new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
}
return entity;
}




}

