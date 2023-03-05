package controlor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.cocoDAO;
import Model.Coco;

/**
 * Servlet implementation class cocoServlet
 */
@WebServlet("/cocoServlet")
public class cocoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
    *

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		cocoDAO cocoDAO = new cocoDAO();
		request.setAttribute("commande", cocoDAO.afficherTousCommandes());
		PrintWriter p = response.getWriter();

		p.print(cocoDAO.afficherTousCommandes().toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		/*private String date;
	private String montant;
	private String mode;
	private String statutPaiement;
	private String modeLivraison;
	private String statutLivraison;
	*/
		
		String date = request.getParameter("date");
		String montant = request.getParameter("montant");
		String mode = request.getParameter("paiement");
		String statutPaiement = request.getParameter("statutPaiement");
		String modeLivraison = request.getParameter("livraison");
		String statutLivraison = request.getParameter("statutLivraison");
		
		Coco commande = new Coco();
		
		commande.setDate(date);
		commande.setMontant(montant);
		commande.setMode(modeLivraison);
		commande.setStatutPaiement(statutPaiement);
		commande.setModeLivraison(modeLivraison);
		
		cocoDAO commandeDao = new cocoDAO();
		commandeDao.ajouterCommande(commande);
		
		ArrayList<Coco> arrayCoco = commandeDao.afficherTousCommandes();
		
		request.setAttribute("commande", commande);
		request.setAttribute("array", arrayCoco);
		

		this.getServletContext().getRequestDispatcher("/WEB-INF/vueCoco.jsp").forward(request, response);
	
		
	}

}
