package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.Like;
import web.dto.Musical;
import web.service.face.McService;
import web.service.impl.McServiceImpl;


@WebServlet("/musical/mcView")
public class McViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//서비스 객체
	private McService mcService = new McServiceImpl();

	private Object viewMc;
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("mcno"));

		
		//전달파라미터 저장 객체 얻기
		Musical mcno = mcService.getMcno(req);
//		System.out.println("전달파라미터 객체 : " + mcno);
				
		//상세보기 결과 조회
		Musical viewMc = mcService.view(mcno);
//		System.out.println("상세보기 객체 : " + viewMc);
				
		//조회결과 MODEL값 전달
		req.setAttribute("viewMc", viewMc);


		
		//기존 좋아요 유무 확인
		Like like = mcService.getLIkes(req);
		like.setUserid((String)req.getSession().getAttribute("userid"));
		boolean isLike = mcService.like(like);
		req.setAttribute("isLike", isLike);
//		System.out.println( "isLike : " + isLike);
		
		//VIEW 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/musical/mcView.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("likechk: " + req.getParameter("likechk") + 
							" userid: " + req.getParameter("userid") +
							" mcno :" + req.getParameter("mcno") );
		//전달파라미터 저장 객체 얻기
		Like like = mcService.getLIkes(req);
		
//		System.out.println("저장된 req" + like);
		
		//로그아웃 상태 좋아요 이후 상세보기 결과 조회
		if(like.getUserid() == null) {
			int likemcno = like.getMcno();
			Musical likemu = mcService.getLikeMcno(likemcno);
			Musical viewMc = mcService.view(likemu);
			req.setAttribute("viewMc", viewMc);
//			System.out.println("상세보기 nologin post객체 : " + viewMc);
			
			//상세보기 결과 세션값으로 전달
			HttpSession session = req.getSession();
			session.setAttribute("viewMc", viewMc);

		//로그인 상태 좋아요 이후 
		} else {
			
			//기존 좋아요 유무 확인
			boolean isLike = mcService.like(like);
			
			if(isLike) {
//				System.out.println("islogintrue"+like);
				//좋아요 삭제
				mcService.deleteLike(like);
				
				//좋아요 수 업데이트(-1)
				mcService.updateLikeM(like);
				
				int likemcno = like.getMcno();
				Musical likemu = mcService.getLikeMcno(likemcno);
				Musical viewMc = mcService.view(likemu);
//				System.out.println("상세보기 login -좋아요객체 : " + viewMc);
				//상세보기 조회 결과
				HttpSession session = req.getSession();
				session.setAttribute("viewMc", viewMc);
				
			} else {
				
//				System.out.println("로그인쪽222"+like);
				//좋아요 삽입
				mcService.insertLike(like);
				
				//좋아요 수 업데이트(+1)
				Musical viewMc = mcService.updateLikeP(like);
				
//				System.out.println("상세보기 login +좋아요객체 : " + viewMc);
				//상세보기 조회 결과
				HttpSession session = req.getSession();
				session.setAttribute("viewMc", viewMc);
			}
			
		}
		
		//뮤지컬 상세보기로 리다이렉트
		resp.sendRedirect("/musical/mcView?mcno=" + req.getParameter("mcno"));
	
	}

}
