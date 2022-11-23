package view;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import dao.BoardDAO;

//�ٿ�ε� â�� ���� ���� �� ������
public class BoardDownLoadView extends AbstractView{

   private BoardDAO dao;
   
   public BoardDownLoadView() {

   }
   
   public void setDao(BoardDAO dao) {
      this.dao = dao;
   }

   @Override
   protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
         HttpServletResponse response) throws Exception {
      int num = Integer.parseInt(request.getParameter("num"));
      
      String root = request.getSession().getServletContext().getRealPath("/");
      String saveDirectory = root + "temp" + File.separator;
      
      String upload = dao.getFile(num);
      String fileName = upload.substring(upload.indexOf("_") + 1);
      
      //���ϸ��� �ѱ��϶� ���ڵ� �۾��� �Ѵ�.
      String str = URLEncoder.encode(fileName,"UTF-8"); 
      
      //�������ϸ��� ������ ���� ��, +ǥ�ð� �ǹǷ� �������� ó������
      str = str.replaceAll("\\+", "%20");
      
      //������ Ÿ��
      response.setContentType("application/octet-stream");
      
      //�ٿ�ε� â�� ������ ���ϸ��� �����Ѵ�.
      response.setHeader("Content-Disposition", "attachment;filename="+str+";");
      
      //������ ����� ������ �о�� Ŭ���̾�Ʈ�� ����� �ش�.
      FileCopyUtils.copy(new FileInputStream(new File(saveDirectory,upload)), response.getOutputStream());
      
      
      
   }
   
   
}