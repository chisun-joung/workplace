package com.multicampus.view.profit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.multicampus.biz.profit.impl.ProfitDAO;
import com.multicampus.biz.profit.vo.ProfitVO;

@WebServlet(name = "profitList", urlPatterns = { "/profitList" })
public class ProfitList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String year = request.getParameter("year");
		System.out.println(year);
		
		ProfitDAO dao = new ProfitDAO();
		
		if(year.equals("all") || year == null){
			HashMap<String, ArrayList<ProfitVO>> map = dao.profitList();
			
			Gson gson = new Gson();
			String result = gson.toJson(map);
			
			PrintWriter out = response.getWriter();
			out.println(result);
		}else{
			ProfitVO vo = new ProfitVO();
			vo.setYear(year);
			HashMap<String, ArrayList<ProfitVO>> map = dao.profitYearList(vo);
			
			Gson gson = new Gson();
			String result = gson.toJson(map);
			
			PrintWriter out = response.getWriter();
			out.println(result);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
