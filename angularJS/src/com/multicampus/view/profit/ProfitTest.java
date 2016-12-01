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

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.multicampus.biz.profit.impl.ProfitDAO;
import com.multicampus.biz.profit.vo.ProfitVO;

@WebServlet(name = "profitTest", urlPatterns = { "/profitTest" })
public class ProfitTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = "";
		String year = "";
		int amount = 0;
		
		// 매개변수를 포함하여 호출. getCall
		if(request.getParameter("type") != null){
			type = request.getParameter("type");
			
			year = request.getParameter("param1");
			amount = Integer.parseInt(request.getParameter("param2"));
		}
		
		// JSON 형태의 Parameter는 변환해서 사용
		if(request.getParameter("jsonObjParam") != null){
			String jsonObjParam = request.getParameter("jsonObjParam");
			
			JSONParser jp = new JSONParser();
			JSONObject jo = null;
			try {
				jo = (JSONObject) jp.parse(jsonObjParam);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			type = (String) jo.get("type");
			year = (String) jo.get("param1");
			String param2 = (String) jo.get("param2");
			amount = Integer.parseInt(param2);
		}
		
		
		ProfitDAO dao = new ProfitDAO();
		
		if(type.equals("getCall") || type.equals("getJSONCall")){
			
			ProfitVO vo = new ProfitVO();
			vo.setYear(year);
			vo.setAmount(amount);
			
			HashMap<String, ArrayList<ProfitVO>> map = dao.getCall(vo);
			
			Gson gson = new Gson();
			String result = gson.toJson(map);
		
			PrintWriter out = response.getWriter();
			out.println(result);
		}else{
			HashMap<String, ArrayList<ProfitVO>> map = dao.profitList();
		
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
