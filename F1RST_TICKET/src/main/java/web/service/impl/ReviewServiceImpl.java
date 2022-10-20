package web.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import common.JDBCTemplate;
import util.Paging;
import web.dao.face.ReviewDao;
import web.dao.impl.ReviewDaoImpl;
import web.dto.Comment;
import web.dto.Review;
import web.dto.ReviewFile;
import web.service.face.ReviewService;

public class ReviewServiceImpl implements ReviewService {
	
	//DAO 객체
	ReviewDao reviewDao = new ReviewDaoImpl();
	
	//Connection객체
	private Connection conn = JDBCTemplate.getConnection();
	
	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		} else {
			System.out.println("[WARN] BoardService getPaging() - curPage가 null이거나 비어있음");
		}
		
		//총 게시글 수 조회하기
		int totalCount = reviewDao.selectCntAll(JDBCTemplate.getConnection());
		
		//Paging 객체 생성
//		Paging paging = new Paging(totalCount, curPage);
//		Paging paging = new Paging(totalCount, curPage, 9); //한페이지에 9개 게시글 보여주기
		Paging paging = new Paging(totalCount, curPage, 6); //한페이지에 6개 게시글 보여주기
		
		return paging;
	}
	
	@Override
	public List<Review> getList(Paging paging) {
		return reviewDao.selectAll(conn, paging);
	}
	
	@Override
	public Review getReviewno(HttpServletRequest req) {
		
		//전달 파라미터를 저장할 객체 생성
		Review review = new Review();
		
		String param = req.getParameter("reviewno");
		
		if( param != null && !"".equals(param) ) {
			review.setReviewno( Integer.parseInt(param) );
		} else {
			System.out.println("[WARN] ReviewService getReviewno() - reviewno값이 null이거나 비어있음");
		}
		
		return review;		
		
	}
	
	@Override
	public Review view(Review reviewno) {
		return reviewDao.selectReviewByReviewno(conn, reviewno);
	}

	@Override
	public ReviewFile viewFile(Review viewReview) {
		return reviewDao.selectFile(conn, viewReview);
	}
	
	@Override
	public void write(HttpServletRequest req) {
		
		//multipart/form-data 인코딩 확인
		boolean isMultpar = ServletFileUpload.isMultipartContent(req);
		
		//multipar형식이 아닐 경우 처리 중단
		if( !isMultpar ) {
			System.out.println("[ERROR] 파일 업로드 형식 데이터가 아님");
			return;
		}
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//메모리 처리 사이즈 설정
		int maxMem = 1 * 1024 * 1024;	//1 MB == 1048576 B
		factory.setSizeThreshold(maxMem);
		
		//서블릿 컨텍스트 객체
		ServletContext context = req.getServletContext();
		
		//임시 파일 저장 폴더
		String path = context.getRealPath("tmp");
		File tmpRepository = new File(path);
		tmpRepository.mkdir();
		factory.setRepository(tmpRepository);
		
		//파일 업로드 수행 객체
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//파일 업로드 용량 제한
		int maxFile = 10 * 1024 * 1024;	//10MB
		upload.setFileSizeMax(maxFile);
		
		//파일 업로드된 데이터 파싱
		List<FileItem> items = null;
		
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		//게시글 정보 DTO객체
		Review review = new Review();
		
		//게시글 첨부파일 정보 DTO 객체
		ReviewFile reviewFile = new ReviewFile();
		
		//파일아이템의 반복자
		Iterator<FileItem> iter = items.iterator();
		
		while( iter.hasNext() ) {
			
			//전달 파라미터 FileItem을 하나씩 꺼내서 적용하기
			FileItem item = iter.next();
			
			//--- 1) 빈 파일에 대한 처리 ---
			if( item.getSize() <= 0 ) { //전달 데이터의 크기
				
				//빈 파일은 무시하고 다음 FileItem처리로 넘어간다
				continue;
			}
				
			//--- 2) 폼필드에 대한 처리 ---
			if( item.isFormField() ) {
				
				//키(key) 추출하기
				String key = item.getFieldName();
				
				//값(value) 추출하기
				String value = null;
				
				try {
					value = item.getString("UTF-8");	//한글 인코딩 지정
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
				//key에 맞게 value를 DTO에 삽입하기
				if( "reviewtitle".equals(key) ) {
					review.setReviewtitle(value);
				}
				if( "reviewcontent".equals(key) ) {
					review.setReviewcontent(value);
				}
				if( "reviewscope".equals(key) ) {
					//별점 처리
					review.setReviewscope( Integer.parseInt( value ) );
//					review.setReviewscope( 6 - Integer.parseInt( value ) );
				}
				if( "mcno".equals(key) ) {
					review.setMcno( Integer.parseInt(value) );
				}
				
			}// if( item.isFormField() ) END
			
			//--- 3) 파일에 대한 처리 ---
			if( !item.isFormField() ) {
				
				//저장 파일명 처리
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSSS");
				String rename = sdf.format(new Date());	//현재시간
				
				//파일 업로드 폴더
				File uploadFolder = new File( context.getRealPath("upload") );
				uploadFolder.mkdir();
				
				//업로드할 파일 객체 생성하기
				File up = new File(uploadFolder, rename);
				
				try {
					
					item.write(up);	//임시 파일을 실제 업로드 파일로 출력한다
					item.delete();	//임시 파일 제거
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//업로드된 파일의 정보를 DTO객체에 저장하기
				reviewFile.setOriginname(item.getName());
				reviewFile.setStoredname(rename);
				reviewFile.setFilesize((int) item.getSize());
				
			}// if( !item.isFormField() ) END
			
		} //while( iter.hasNext() ) END		

		//게시글 번호 생성
		int reviewno = reviewDao.selectNextReviewno(conn);
		
		//번호 삽입
		review.setReviewno(reviewno);
		
		//작성자 ID처리
		review.setUserid( (String) req.getSession().getAttribute("userid") );
		
		System.out.println(review);
		if( reviewDao.insert(conn, review) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//첨부파일 정보 삽입
		if( reviewFile.getFilesize() != 0 ) {
			
			//게시글 번호 삽입
			reviewFile.setReviewno(reviewno);
			
			if( reviewDao.insertFile(conn, reviewFile) > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
			
		}
		
	}
	
	@Override
	public void update(HttpServletRequest req) {
		
		//multipart/form-data 인코딩 확인
		boolean isMultpar = ServletFileUpload.isMultipartContent(req);
		
		//multipar형식이 아닐 경우 처리 중단
		if( !isMultpar ) {
			System.out.println("[ERROR] 파일 업로드 형식 데이터가 아님");
			return;
		}
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//메모리 처리 사이즈 설정
		int maxMem = 1 * 1024 * 1024;	//1 MB == 1048576 B
		factory.setSizeThreshold(maxMem);
		
		//서블릿 컨텍스트 객체
		ServletContext context = req.getServletContext();
		
		//임시 파일 저장 폴더
		String path = context.getRealPath("tmp");
		File tmpRepository = new File(path);
		tmpRepository.mkdir();
		factory.setRepository(tmpRepository);
		
		//파일 업로드 수행 객체
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//파일 업로드 용량 제한
		int maxFile = 10 * 1024 * 1024;	//10MB
		upload.setFileSizeMax(maxFile);
		
		//파일 업로드된 데이터 파싱
		List<FileItem> items = null;
		
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		//게시글 정보 DTO객체
		Review review = new Review();
		
		//게시글 첨부파일 정보 DTO 객체
		ReviewFile reviewFile = new ReviewFile();
		
		//파일아이템의 반복자
		Iterator<FileItem> iter = items.iterator();
		
		while( iter.hasNext() ) {
			
			//전달 파라미터 FileItem을 하나씩 꺼내서 적용하기
			FileItem item = iter.next();
			
			//--- 1) 빈 파일에 대한 처리 ---
			if( item.getSize() <= 0 ) { //전달 데이터의 크기
				
				//빈 파일은 무시하고 다음 FileItem처리로 넘어간다
				continue;
			}
				
			//--- 2) 폼필드에 대한 처리 ---
			if( item.isFormField() ) {
				
				//키(key) 추출하기
				String key = item.getFieldName();
				
				//값(value) 추출하기
				String value = null;
				
				try {
					value = item.getString("UTF-8");	//한글 인코딩 지정
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
				//key에 맞게 value를 DTO에 삽입하기
				if( "reviewno".equals(key) ) {
					review.setReviewno(Integer.parseInt(value));;;
				}
				if( "reviewtitle".equals(key) ) {
					review.setReviewtitle(value);;
				}
				if( "reviewcontent".equals(key) ) {
					review.setReviewcontent(value);
				}
				if( "reviewscope".equals(key) ) {
					//별점 처리
					review.setReviewscope( Integer.parseInt( value ) );
				}
				
			}// if( item.isFormField() ) END
			
			//--- 3) 파일에 대한 처리 ---
			if( !item.isFormField() ) {
				
				//저장 파일명 처리
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSSS");
				String rename = sdf.format(new Date());	//현재시간
				
				//파일 업로드 폴더
				File uploadFolder = new File( context.getRealPath("upload") );
				uploadFolder.mkdir();
				
				//업로드할 파일 객체 생성하기
				File up = new File(uploadFolder, rename);
				
				try {
					
					item.write(up);	//임시 파일을 실제 업로드 파일로 출력한다
					item.delete();	//임시 파일 제거
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//업로드된 파일의 정보를 DTO객체에 저장하기
				reviewFile.setOriginname(item.getName());
				reviewFile.setStoredname(rename);
				reviewFile.setFilesize((int) item.getSize());
				
			}// if( !item.isFormField() ) END
			
		} //while( iter.hasNext() ) END		

		if( reviewDao.update(conn, review) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//첨부파일 정보 삽입
		if( reviewFile.getFilesize() != 0 ) {
			
			//게시글 번호 삽입
			reviewFile.setReviewno(review.getReviewno());
			
			if( reviewDao.insertFile(conn, reviewFile) > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
			
		}
		
	}

	@Override
	public void delete(Review review) {
		
		//첨부 파일 삭제
		if(reviewDao.deleteFile(conn, review) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		//댓글 삭제
		if(reviewDao.deleteComment(conn, review) > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//게시글 삭제
		if(reviewDao.delete(conn, review) > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}
	
}