package Servlets;

import jakarta.servlet.http.HttpServlet;

import java.awt.geom.Path2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpRequest;
import java.nio.file.Paths;
import java.time.temporal.IsoFields;
import java.util.List;

import javax.persistence.criteria.Root;

import org.hibernate.internal.util.BytesHelper;
import org.hibernate.query.criteria.internal.expression.SearchedCaseExpression.WhenClause;

import Entity.Files;
import FileDao.FilesModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
@MultipartConfig
public class MyServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
     int fileId=0;      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String page = request.getParameter("page");
		if(page!=null) {
	
			if(page.equals("updatePage"))
		{
				fileId = Integer.parseInt( request.getParameter("fileID"));
			readsingleUser(request,response, fileId);
            request.getRequestDispatcher("updateFile.jsp").forward(request, response);
	
		}else {
		
			response.sendRedirect("registrationForm.jsp");
	   
		}
		}else {
			response.sendRedirect("registrationForm.jsp");

		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String operation = request.getParameter("operation");
		if(operation!=null) {
	   switch (operation) 
	   {
	case "ADDregistrationDt": {
	
	    addRowData(request);
	    readFilesDB(request);
	request.getRequestDispatcher("DetailsListPagee.jsp").forward(request, response);
    break;
	}
	case "updateFile" :{
             
	           updateFile(request);
		
	}
	default:
	}
		}
	   
	}
	

	public void getandCreateImage(InputStream ipStream,String fileName) throws IOException,ServletException{
		
		String path = "c:/images";
		try {

		Boolean isDir = true;
	    File filedir = new File(path);
	    if(!filedir.exists())
	    {
	    isDir = 	filedir.mkdir();
	    }
	    if(isDir)
	    {
	    	File file = new File(path+File.separator+fileName);
	    	boolean isFile = true;
	    	if(!file.exists())
	    	{
	    	isFile = 	file.createNewFile();
	    	}
	    	if(isFile)
	    	{
	    		FileOutputStream outputStream  = new FileOutputStream(file);
	   	     byte[] bytes = ipStream.readAllBytes();
	   	     outputStream.write(bytes);
	 	    outputStream.close();
	    	}
	    }
		}catch (Exception e) {
		}
	}

	public void addRowData(HttpServletRequest request) throws IOException,ServletException{
		
		Part filePart = request.getPart("image"); // Retrieves <input type="file" name="file">
		String fileNameee = Paths.get(filePart.getSubmittedFileName()).getFileName().getFileName().toString();// MSIE fix.
       
		String label =	request.getParameter("label");
        String caption =	request.getParameter("caption");
    	String username =	request.getParameter("username");
    	int rollnumber =	Integer.parseInt(request.getParameter("rollnumber"));
	    String course =	request.getParameter("course");

	    InputStream ipStream = filePart.getInputStream();	
	    getandCreateImage(ipStream,fileNameee);
	   
	    Files files = new Files(fileNameee,label,caption,username,rollnumber,course);
	    new FilesModel().addData(files);
	}
	
	public void readFilesDB(HttpServletRequest request){
		
		List<Files> list = new  FilesModel().readAllFiles();
		request.setAttribute("DbList", list);
	}
	
	private void readsingleUser(HttpServletRequest request, HttpServletResponse response, int  id) throws IOException,ServletException{

		Files files =	(Files) new FilesModel().readAfile(id);
	 
		request.setAttribute("FILESobj", files);
	
	   System.out.println( files.getLabel()+"      "+  files.getUsername());
	   
	  // request.getRequestDispatcher("updateFile.jsp").forward(request, response);

		}

  private void updateFile(HttpServletRequest request) throws IOException,ServletException{
	  
	  
	  String labelString = 	request.getParameter("updateLABEL");
		String caption = 	request.getParameter("updateCAPTION");
		String username = 	request.getParameter("updateUSERNAME");
		int rollno = 	Integer.parseInt(request.getParameter("updateROLLNUMBER"));
		
		
	  Files files =	(Files) new FilesModel().readAfile(fileId );
	  new FilesModel().updateAFile(files , new Files(labelString,caption,username,rollno));
	  
  }
}




















































































