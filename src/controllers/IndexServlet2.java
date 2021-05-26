package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Tasks;
import utils.DButil;

/**
 * Servlet implementation class IndexServlet2
 */
@WebServlet("/index")
public class IndexServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet2() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DButil.createEntityManager();

        List<Tasks> tasks = em.createNamedQuery("getAllTasks", Tasks.class).getResultList();


        em.close();


        request.setAttribute("tasks", tasks);

        if(request.getSession().getAttribute("flush") != null) {
            // セッションスコープ内のフラッシュメッセージをリクエストスコープに保存し、セッションスコープからは削除する
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/index2.jsp");
        rd.forward(request, response);

    }

}
