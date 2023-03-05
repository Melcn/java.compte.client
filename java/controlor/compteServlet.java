package controlor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.compteDao;
import Model.compte;

/**
 * Servlet implementation class ServletCompte
 */
@WebServlet("/ServletCompte")
public class compteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		compteDao ccDao = new compteDao();
		request.setAttribute("compte", ccDao.afficherTousComptes());
		PrintWriter p = response.getWriter();

		p.print(ccDao.afficherTousComptes().toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String titulaire = request.getParameter("titulaire");
		Integer numero = Integer.parseInt(request.getParameter("num"));
		double solde = Double.parseDouble(request.getParameter("solde"));
		String radioCompte = request.getParameter("compte");

		compte cc = new compte();
		cc.setTitulaire(titulaire);
		cc.setNumero(numero);
		cc.setSolde(solde);

		compteDao ccD = new compteDao();
		ArrayList<compte> tab = ccD.afficherTousComptes();

		switch (radioCompte) {
		case "Creer":
			ccD.ajouterCompte(cc);
			break;

		case "Crediter":
			
			for (compte compte : tab) {

				if (numero == compte.getNumero()) {
					ccD.crediter(cc, solde);
				}

			}
			
		
			break;

		case "Debiter":

			for (compte compte : tab) {

				if (numero == compte.getNumero()) {
					ccD.debiter(numero, solde);
				}

			}
			
			
			break;
		}

		request.setAttribute("compte", cc);
		request.setAttribute("tableau", tab);

		this.getServletContext().getRequestDispatcher("/WEB-INF/vueCompte.jsp").forward(request, response);

	}

}