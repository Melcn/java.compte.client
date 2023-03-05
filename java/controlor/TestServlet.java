package controlor;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClicliDAO;
import Model.Clicli;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/mappage")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		ClicliDAO dao = new ClicliDAO();
		request.setAttribute("compte", dao.afficherTousComptes());
		PrintWriter p = response.getWriter();

		p.print(dao.afficherTousComptes().toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);


		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adress");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		
		Clicli client = new Clicli();
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setAdresse(adresse);
		client.setTelephone(tel);
		client.setMail(email);
		
		ClicliDAO clientDao = new ClicliDAO();
		clientDao.ajouterCompte(client);
		ArrayList<Clicli> arrayCli = clientDao.afficherTousComptes();
		
		

		request.setAttribute("compte", client);
		request.setAttribute("array", arrayCli);
		

		this.getServletContext().getRequestDispatcher("/WEB-INF/vue.jsp").forward(request, response);
	}

}
