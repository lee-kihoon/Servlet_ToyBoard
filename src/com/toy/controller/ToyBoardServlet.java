package com.toy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.toy.dto.ToyBoardDto;
import com.toy.dto.ToyMemberDto;
import com.toy.service.ToyBoardService;
import com.toy.service.ToyBoardServiceImpl;
import com.toy.service.ToyMemberService;
import com.toy.service.ToyMemberServiceImpl;

/**
 * Servlet implementation class ToyBoardServlet
 */
@WebServlet("/controller.do")
public class ToyBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToyBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    // 인코딩
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    
	    // 요청받을 변수 선언
	    String command = request.getParameter("command");
	    ToyBoardService boardService = new ToyBoardServiceImpl();
	    ToyMemberService memberService = new ToyMemberServiceImpl();
	    
	    
	    if (command.equals("main")) {
	        List<ToyBoardDto> list = boardService.selectAll();
	        request.setAttribute("list",  list);
	        if ( (String)session.getAttribute("Id") != null) {
	        dispatch("main.jsp", request, response);
	        } else {
	        dispatch("index.jsp", request, response);
	        }
	    } else if (command.equals("one")) {
	        int no = Integer.parseInt(request.getParameter("no"));
	        ToyBoardDto dto = boardService.selectOne(no);
	        
	        request.setAttribute("dto", dto);
	        dispatch("selectone.jsp", request, response);
	    } else if (command.equals("insert")) {
	        response.sendRedirect("insert.jsp");
	    } else if(command.equals("boardInsert")) {
	        String userId = request.getParameter("f_userId");
	        String title = request.getParameter("f_title");
	        String contents = request.getParameter("f_contents");
	        
	        ToyBoardDto dto = new ToyBoardDto(userId, title, contents);
	        boolean res = boardService.insert(dto);
	        
	        if(res) {
	            jsResponse("게시글이 성공적으로 작성되었습니다.", "controller.do?command=main", response);
	        } else {
	            dispatch("controller.do?command=insert", request, response);
	        }
	    } else if(command.equals("update")) {
	        int no = Integer.parseInt(request.getParameter("no"));
	        ToyBoardDto dto = boardService.selectOne(no);
	        
	        request.setAttribute("dto", dto);
	        
	        dispatch("update.jsp", request, response);
	    } else if(command.equals("boardUpdate")) {
	        int no = Integer.parseInt(request.getParameter("no"));
	        String title = request.getParameter("f_title");
	        String contents = request.getParameter("f_contents");
	        
	        ToyBoardDto dto = new ToyBoardDto(no, title, contents);
	            boolean res = boardService.update(dto);
	            
	            if(res) {
	                jsResponse("게시글이 성공적으로 수정되었습니다.", "controller.do?command=one&no=" + no, response);
	            }  else {
	                dispatch("controller.do?command=update&no=" + no, request, response);
	            }
	    } else if(command.equals("delete")) {
	        int no = Integer.parseInt(request.getParameter("no") );
	        
	        boolean res = boardService.delete(no);
	        if(res) {
                jsResponse("게시글이 성공적으로 삭제되었습니다.", "controller.do?command=main", response);
            } else {
                dispatch("controller.do?command=one&no=" + no, request, response);
            } 
	    } else if (command.equals("memberLogin")) {
            String userId = request.getParameter("f_userId");
            String password = request.getParameter("f_password");
            
            ToyMemberDto dto = memberService.selectOne(userId, password);
            session = request.getSession(true);// true
            request.setAttribute("dto", dto);
            if(session !=null) session.setAttribute("Id", dto.getUserId());

            dispatch("index.jsp", request, response);
            
        } else if (command.equals("sign_up") ) {
	        response.sendRedirect("sign_up.jsp");
        } else if(command.equals("memberInsert")) {
            String userId = request.getParameter("f_userId");
            String password = request.getParameter("f_password");
            
            ToyMemberDto dto = new ToyMemberDto(userId, password);
            boolean res = memberService.insert(dto);
            
            if(res) {
                jsResponse("회원가입이 완료되었습니다.", "controller.do?command=main", response);
            } else {
                dispatch("controller.do?command=sign_up", request, response);
            }
        } else if (command.equals("logout") ) {
            session.invalidate();
            response.sendRedirect("index.jsp");
        }
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher dispatch = request.getRequestDispatcher(url);
	    dispatch.forward(request,  response);
	}
	
	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
	    String alert = "<script type='text/javascript'>" +
	                    "alert('" + msg + "');" +
	                    "location.href='"+ url + "';" +
	                    "</script>";
	    PrintWriter out = response.getWriter();
	    out.print(alert);
	}
 	

}
