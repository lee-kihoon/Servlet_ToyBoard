package com.toy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toy.dto.ToyBoardDto;
import com.toy.service.ToyBoardService;
import com.toy.service.ToyBoardServiceImpl;

/**
 * Servlet implementation class ToyBoardServlet
 */
@WebServlet("/controller.do")
public class ToyBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
	    ToyBoardService service = new ToyBoardServiceImpl();
	    
	    if (command.equals("main")) {
	        List<ToyBoardDto> list = service.selectAll();
	        request.setAttribute("list",  list);
	        
	        dispatch("main.jsp", request, response);
	    } else if (command.equals("one")) {
	        int no = Integer.parseInt(request.getParameter("no"));
	        ToyBoardDto dto = service.selectOne(no);
	        
	        request.setAttribute("dto", dto);
	        dispatch("selectone.jsp", request, response);
	    } else if(command.equals("insert")) {
	        response.sendRedirect("insert.jsp);
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
	

}
