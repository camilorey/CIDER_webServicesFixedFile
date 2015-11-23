

import CIDER_DB.CIDER_DB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laptop
 */
public class DataHandler extends HttpServlet{
 protected String fileName ="baseDeDatos_emailInstitucional.xlsx";
 protected String filePath ="C:\\desarrollo\\desarrolloCIDER\\CIDER_webServicesFixedFile\\data";
 protected static CIDER_DB DataBase;
 
 /**
 * this life-cycle method is invoked when this servlet is first accessed
 * by the client
 */
 @Override
 public void init(ServletConfig config) {
  System.out.println("Servlet is being initialized");
 }
 
 /**
  * handles HTTP GET request
  */
 @Override
 public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
 
  PrintWriter writer = response.getWriter();
  writer.println("<html>Hello, I am a Java servlet!</html>");
  writer.flush();
 }
 /**
  * handles HTTP POST request
 */
 @Override
 public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
  PrintWriter writer = response.getWriter();
  DataBase = new CIDER_DB(filePath, fileName);
  writer.println("<html>");
  writer.println("<body>");
  writer.println("<h1>Data Base Loaded</h1>");
  writer.println("file name: "+fileName);
  writer.println("<br>");
  writer.println("file path: "+filePath);
  writer.println("<br>");
  writer.println("<h2>Data Base Response</h2>");
  writer = DataBase.createDB(writer);
  writer.println("</body>");
  writer.println("</html>");
  writer.flush();
 }
 /**
 * this life-cycle method is invoked when the application or the server
 * is shutting down
 */
 @Override
 public void destroy() {
  System.out.println("Servlet is being destroyed");
 }
   
}
