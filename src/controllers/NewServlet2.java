package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Tasks;

/**
 * Servlet implementation class NewServlet2
 */
@WebServlet("/new")
public class NewServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet2() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("_token", request.getSession().getId());

        // おまじないとしてのインスタンスを生成
        request.setAttribute("task", new Tasks());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/new2.jsp");
        rd.forward(request, response);
     }
}