package controllers;

import java.io.IOException;

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
 * Servlet implementation class ShowServlet2
 */
@WebServlet("/show")
public class ShowServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet2() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DButil.createEntityManager();

        // 該当のIDのメッセージ1件のみをデータベースから取得
        Tasks t = em.find(Tasks.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        // メッセージデータをリクエストスコープにセットしてshow.jspを呼び出す
        request.setAttribute("task", t);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/show2.jsp");
        rd.forward(request, response);	}

}
