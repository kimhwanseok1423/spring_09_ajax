package part01_mybatis;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemDaoImp implements MemDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

public MemDaoImp() {
	
}

@Override
public List<MemDTO> list() {
	// TODO Auto-generated method stub
	return sqlSession.selectList("mem.all");
}

@Override
public void insertMethod(MemDTO dto) {
	sqlSession.insert("mem.ins",dto);
	
}

@Override
public MemDTO updateMethod(int num) {
return	 null;
	
}

@Override
public void updateMethod(MemDTO dto) {
	sqlSession.update("mem.upt",dto);
	
}

@Override
public void deleteMethod(int num) {
	sqlSession.delete("mem.del",num);
}

@Override
public MemDTO one(int num) {
	
	return sqlSession.selectOne("mem.one",num);
}

@Override
public int countMethod() {
	// TODO Auto-generated method stub
	return 0;
}

}
