package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import dto.BoardDTO;
import dto.PageDTO;

public class BoardDaoImp implements BoardDAO{
	private SqlSessionTemplate sqlSession;
	
	
	public BoardDaoImp() {
	
	}
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
		
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("board.count");
	}

	@Override
	public List<BoardDTO> list(PageDTO pv) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("board.list",pv);
	}

	@Override   //조회수 하는법2
	public void readCount(int num) {
		
		sqlSession.update("board.readCount",num);
	}

	@Override  //조회수 하는법2
	public BoardDTO content(int num) {
		
		return sqlSession.selectOne("board.view",num);
	}

	@Override
	public void reStepCount(BoardDTO dto) {
		sqlSession.update("board.reStepCount",dto);
		
	}

	@Override
	public void save(BoardDTO dto) {
		sqlSession.insert("board.save",dto);
		
	}

	@Override
	public BoardDTO updateNum(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BoardDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.update("board.update",dto);
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		sqlSession.delete("board.delete",num);
	}

	@Override  // 파일클릭시 첨부파일을 다운받도록
	public String getFile(int num) {
	
		return sqlSession.selectOne("board.uploadFile",num);
	}
	
	
	
}//end class
