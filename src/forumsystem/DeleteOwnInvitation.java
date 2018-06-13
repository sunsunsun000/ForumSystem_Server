package forumsystem;

import idao.DAOFactory;
import idao.IInvitation;
import utils.UserUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "delete", urlPatterns = "/delete")
public class DeleteOwnInvitation extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        // delete the invitation by these parameters, 'author', 'content', 'date'
        String content = request.getParameter("content");
        String date = request.getParameter("date");
        IInvitation iInvitation = DAOFactory.createInvitationDao();
        String result = "";
        if (UserUtil.getUserInstance() != null) {
            result = iInvitation.deleteOwnInvitation(UserUtil.getUserInstance(), content, date);
        }
        pw.write(result);
        pw.close();
    }
}
