
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AverageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // get the current session
        HttpSession session = request.getSession();
        
        // get the "operation" parameter and check if it contains the value "reset"
        String operation = request.getParameter("operation");
        if( operation != null && operation.equals("reset") ){
            // if the reset button was clicked, destroy current session
            session.invalidate();
            // re-instantiate session, so that other code can use the session object
            session = request.getSession();
        }
        
        // get the number list from the session
        ArrayList<Integer> numberList = (ArrayList<Integer>)session.getAttribute("numberList");
        // if the number list exists, use the current list
        // otherwise, create a new list
        // singleton pattern
        if( numberList == null ){
            numberList = new ArrayList<>();
        }
        
        // check if the user entered a number
        if( request.getParameter("number") != null ){
            // if there is a number, add it to the list
            int number = Integer.parseInt(request.getParameter("number"));
            numberList.add(number);
            // save the number list back to the session
            session.setAttribute("numberList", numberList);
        }
        
        // math time!
        double average = 0.0;
        for( int number : numberList ){
            average += number;
        }
        if(numberList.size() > 0){
            average /= numberList.size();
        }
        
        
        
        // store the average in the request object
        // the average will need to be recalculated for each request (page view)
        request.setAttribute("average", average);
        
        // load the JSP
        getServletContext().getRequestDispatcher("/WEB-INF/average.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //nothing here
    }

}
