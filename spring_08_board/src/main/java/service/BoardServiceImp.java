package service;

import java.io.File;
import java.util.List;

import dao.BoardDAO;
import dto.BoardDTO;
import dto.PageDTO;

public class BoardServiceImp implements BoardService {
	private BoardDAO dao;

	public BoardServiceImp() {
		// TODO Auto-generated constructor stub
	}

	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}

	@Override
	public int countProcess() {
		// TODO Auto-generated method stub
		return dao.count();
	}

	@Override
	public List<BoardDTO> listProcess(PageDTO pv) {
		// TODO Auto-generated method stub
		return dao.list(pv);
	}

	@Override
	public void insertProcess(BoardDTO dto) {
		// 답변글이면
		if (dto.getRef() != 0) {
			dao.reStepCount(dto);
			dto.setRe_step(dto.getRe_step() + 1);
			dto.setRe_level(dto.getRe_level()+1);
		}
		dao.save(dto);
	}

	@Override // 조회수 하는법2
	public BoardDTO contentProcess(int num) {
		dao.readCount(num);
		return dao.content(num);
	}

	@Override
	public void reStepCount(BoardDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public BoardDTO updateSelectProcess(int num) {
		// TODO Auto-generated method stub
		return dao.content(num);
	}

	@Override
	public void updateProcess(BoardDTO dto, String urlpath) {
		//수정한 파일 있으면
		String filename=dto.getUpload();
		if(filename !=null) {
			String path=dao.getFile(dto.getNum());
			//기존 첨부파일이 있으면
			if(path!=null) {
				File file=new File(urlpath,path);
				file.delete();
			}
		}
		
		dao.update(dto);
	}

	@Override
	public void deleteProcess(int num, String urlpath) {
		// TODO Auto-generated method stub
String path=dao.getFile(num);
//num컬럼에 해당하는 첨부파일이 있으면 
if(path!=null) {
	File fe=new File(urlpath,path);
	fe.delete();
}
dao.delete(num);
	}

	@Override // 파일클릭시 첨부파일을 다운받도록 -->
	public String fileSelectprocess(int num) {
		// TODO Auto-generated method stub
		return dao.getFile(num);
	}

}
