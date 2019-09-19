package servlets;

import domains.Note;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 784564
 */
public class NoteServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        //Reader
            
          
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
           
            String ReadTitle = br.readLine();
            String ReadContent = br.readLine();
            
            request.setAttribute("ReadTitle",ReadTitle);
            request.setAttribute("ReadContent",ReadContent);
            
            Note n = new Note(ReadTitle, ReadContent);
            
            request.setAttribute("ReadNote", n);
            
            br.close();
        
            String a = request.getParameter("edit");
            
            if(a==null)
            {
                getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
            }
            else
            {
                getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                .forward(request, response);
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String title_s = request.getParameter("title");
            String content_s = request.getParameter("content");
            
            //Reader & Writer
                        
            
            String line;
            
            String result;
            log(title_s);
            
            request.setAttribute("title",title_s);
            request.setAttribute("content",content_s);
            
            if ( title_s == null || title_s.equals("")|| content_s == null || content_s.equals(""))
            {
                String error = "Type title and context";
                request.setAttribute("result", error);
                
                getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                    .forward(request, response);
            return;
            }
                //Write in the file
                String path = getServletContext().getRealPath("/WEB-INF/note.txt");
                PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
                
                
                
                String writtenTitle = request.getParameter("title");
                String writtenContent = request.getParameter("content");
                
           
                
               // pw.println(writtenTitle);
               // pw.println(writtenContent);
                
                pw.write(writtenTitle+"\n");
                pw.write(writtenContent);
                
                Note n = new Note(writtenTitle, writtenContent);
                request.setAttribute("ReadNote", n);
                
                
                pw.close();
                getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);

            
            
    
    }
    }

  
