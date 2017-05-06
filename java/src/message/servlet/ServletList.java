package message.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import message.dao.AdmissionInformationDao;
import message.dao.impl.AdmissionInformationDaoImpl;
import message.domain.AdmissionInformation;
import sun.net.www.content.text.plain;

/**
 * Servlet implementation class ServletList
 */
@WebServlet("/ServletList")
public class ServletList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String servletContext = request.getServletPath();
		String servletPath = servletContext.substring(1,servletContext.length());
		try {
			Method method = getClass().getDeclaredMethod(servletPath, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
			
		} catch (Exception e) {
			request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			e.printStackTrace();
		}

	}
	
	protected void ServletList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdmissionInformationDao aidi = new AdmissionInformationDaoImpl();
        List<AdmissionInformation> list = new ArrayList<>();
        
        String major1 = new String(request.getParameter("major"));//获取专业名
        String type = new String(request.getParameter("type"));//获取文理科
        String location = new String(request.getParameter("location"));//获取地名
        System.out.println(major1+","+type+","+location);
        list = aidi.getAdmisInfForList(major1,type,location);
        
        String major = "";//计划招生
        String plan = "";//计划招生
        String year = "";//计划招生
        System.out.println(list);
        if(list!=null){
        	for(int i = 0;i<list.size();i++){
        		if(i == 0){
        			plan += "[";
        		}
        		plan += "'" + list.get(i).getPlan() + "',";
        		if(i == list.size()-1){
        			plan += "]";
        		}
        	}
        	for(int i = 0;i<list.size();i++){
        		if(i == 0){
        			major += "[";
        		}
        		major += "'" + list.get(i).getMajor() + "',";
        		if(i == list.size()-1){
        			major += "]";
        		}
        	}
        	for(int i = 0;i<list.size();i++){
        		if(i == 0){
        			year += "[";
        		}
        		year += "'" + list.get(i).getYear() + "',";
        		if(i == list.size()-1){
        			year += "]";
        		}
        	}
        }
        System.out.println(plan);
        System.out.println(major);
        System.out.println(year);
        request.setAttribute("year", year);
        request.setAttribute("plan", plan);
        request.setAttribute("major", major);
        
        //request.setAttribute("list", list);
        //String major = new String(request.getParameter("major").getBytes("ISO-8859-1"),"UTF-8"); 
        
        request.getRequestDispatcher("/result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
