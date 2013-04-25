package com.lf.movie.admin.controllers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.lf.movie.admin.dao.MovieDao;
import com.lf.movie.admin.dto.Movie;
import com.sun.org.apache.bcel.internal.generic.GETFIELD;

/**
 * Servlet implementation class AdminAddServlet
 */
@WebServlet("/AdminAddServlet")
public class AdminAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Movie movie1 = new Movie();
	MovieDao dao = new MovieDao();
	private static final String UPLOAD_DIRECTORY = "upload";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/pages/admin/add.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// checks if the request actually contains upload file
		if (!ServletFileUpload.isMultipartContent(request)) {
			PrintWriter writer = response.getWriter();
			writer.println("Request does not contain upload data");
			writer.flush();
			return;
		}

		// configures upload settings
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(THRESHOLD_SIZE);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(MAX_REQUEST_SIZE);

		// constructs the directory path to store upload file
		String uploadPath = getServletContext().getRealPath("")
				+ File.separator + UPLOAD_DIRECTORY;
		// creates the directory if it does not exist
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			// parses the request's content to extract file data
			List formItems = upload.parseRequest(request);
			Iterator iter = formItems.iterator();

			// iterates over form's fields
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();

				// processes only fields that are not form fields
				if (!item.isFormField()) {
					String fileName = new File(item.getName()).getName();
					String filePath = uploadPath + File.separator + fileName;
					File storeFile = new File(filePath);

					// saves the file on disk
					item.write(storeFile);
					movie1.setimage(fileName);
					System.out.println(filePath);
				} else {
					//System.out.println("eeeeee");
					//String print = request.getParameter("fname");
					//System.out.println(print);
					String name = item.getFieldName();
//                         if(name.equals("fname")){
//                        	 String Name=item.getString();
//                        	 movie1.setname(Name);
//                        	 System.out.println(Name);
//                         }
                         if(name.equals("desc")){
                        	String Descrip=item.getString();
                        	movie1.setdesc(Descrip);
                        	System.out.println(Descrip);
                         }
                         if(name.equals("rdate")){
                        	 String Rdate=item.getString();
                        	 movie1.setrelease_date(Rdate);
                        	 System.out.println(Rdate);
                         }
                         if(name.equals("fname")){
                        	 String name_name=item.getString();
                        	 movie1.setname(name_name);
                        	 System.out.println(name_name);
                        	 
                        	 
                         }
                         if(name.equals("director")){
                        	 String direct=item.getString();
                        	 movie1.setdirector(direct);
                        	 System.out.println(direct);
                         }
					if(name.equals("writer")){
						String writer=item.getString();
						movie1.setwriter(writer);
						System.out.println(writer);
					}
					if(name.equals("producer")){
						String producer=item.getString();
						movie1.setproducer(producer);
						System.out.println(producer);
					}
                    
                    
				}
			}
			request.setAttribute("message",
					"Upload has been done successfully!");
		} catch (Exception ex) {
			// request.setAttribute("message", "There was an error: " +
			// ex.getMessage());
		}
		try {
			dao.addMovie(movie1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// getServletContext().getRequestDispatcher("/message.jsp").forward(request,
		// response);
		response.sendRedirect(request.getContextPath() + "/AdminHome");
	}
}

// Movie movie1 = new Movie();
// MovieDao addmovie = new MovieDao();
// PrintWriter out = response.getWriter();
// boolean isMultipart = ServletFileUpload.isMultipartContent(request);
// System.out.println("request: " + request);
// if (!isMultipart) {
// System.out.println("File Not Uploaded");
// } else {
//
// // System.out.println("thisis");
// // Movie movie = new Movie();
// // movie.setname(request.getParameter("name"));
// // movie.setrelease_date(request.getParameter("rdate"));
// // movie.setdesc(request.getParameter("desc"));
// // movie.setimage(finalimage);
//
// // try {
// // addmovie.addMovie(movie);
// // } catch (Exception e) {
// // // TODO Auto-generated catch block
// // e.printStackTrace();
// // }
//
// FileItemFactory factory = new DiskFileItemFactory();
// ServletFileUpload upload = new ServletFileUpload(factory);
// List items = null;
//
// try {
// items = upload.parseRequest(request);
// System.out.println("items: " + items);
// } catch (FileUploadException e) {
// e.printStackTrace();
// }
// Iterator itr = items.iterator();
// while (itr.hasNext()) {
// FileItem item = (FileItem) itr.next();
// if (item.isFormField()) {
// //String name = item.getFieldName();
// String fieldName = item.getFieldName();
// if(fieldName.equals("fname")){
// String Name = item.getString();
// movie1.setname(item.getString(Name));
// }
// if(fieldName.equals("rdate")){
// String rdate = item.getString();
// movie1.setrelease_date(rdate);
// }
// if(fieldName.equals("desc")){
// String Descrip= item.getString();
// movie1.setdesc(Descrip);
// }
//
//
//
//
//
//
// //System.out.println("name: " + name);
// // String value = item.getString();
// // System.out.println("value: " + value);
// } else {
// try {
// String itemName = item.getName();
// Random generator = new Random();
// int r = Math.abs(generator.nextInt());
//
// String reg = "[.*]";
// String replacingtext = "";
// System.out.println("Text before replacing is:-"
// + itemName);
// Pattern pattern = Pattern.compile(reg);
// Matcher matcher = pattern.matcher(itemName);
// StringBuffer buffer = new StringBuffer();
//
// while (matcher.find()) {
// matcher.appendReplacement(buffer, replacingtext);
// }
// int IndexOf = itemName.indexOf(".");
// String domainName = itemName.substring(IndexOf);
// System.out.println("domainName: " + domainName);
//
// String finalimage = buffer.toString() + "_" + r + domainName;
// System.out.println("Final Image===" + finalimage);
//
// File savedFile = new File(getServletContext()
// .getRealPath("")
// + File.separator
// + finalimage);
// System.out.println();
// item.write(savedFile);
// movie1.setimage(finalimage);
// System.out.println("Test........." + savedFile);
// // out.println("<html>");
// // out.println("<body>");
// // out.println("<table><tr><td>");
// // out.println("<img src=images/"+finalimage+">");
// // out.println("</td></tr></table>");
//
// // Connection conn = null;
// // String url = "jdbc:mysql://localhost:3306/";
// // String dbName = "test";
// // String driver = "com.mysql.jdbc.Driver";
// // String username = "";
// // String userPassword = "";
// // String strQuery = null;
// // String strQuery1 = null;
// String imgLen = "";
//
// try {
// System.out.println("itemName::::: " + itemName);
// // Class.forName(driver).newInstance();
// // conn =
// // DriverManager.getConnection(url+dbName,username,
// // userPassword);
// // Statement st = conn.createStatement();
// // strQuery =
// // "insert into img(path) values('"+finalimage+"')";
// // int rs = st.executeUpdate(strQuery);
// // System.out.println("Query Executed Successfully++++++++++++++");
// // out.println("image inserted successfully");
// // out.println("</body>");
// // out.println("</html>");
// } catch (Exception e) {
// System.out.println(e.getMessage());
// } finally {
// // conn.close();
// }
// } catch (Exception e) {
// e.printStackTrace();
// }
// }
// }
// }
//
// try {
// addmovie.addMovie(movie1);
// } catch (Exception e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// }
// response.sendRedirect(request.getContextPath() + "/AdminHome");
// }

