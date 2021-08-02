package com.arcesi.arcesi.api.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arcesi.arcesi.controller.LoginController;
import com.arcesi.arcesi.model.Video;
import com.arcesi.arcesi.model.VideoJSON;
import com.google.gson.Gson;

@WebServlet("/valider")
public class RestApiVideos extends HttpServlet implements Servlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RestApiVideos() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("------------------------REST API doGet-----------------------");

		// récupération du titre fournit par l'utilisateur
		String titreFournit = request.getParameter("texte");

		// récupération du manager pour accéder à la base de données
//		ChannelManager cm = ChannelManager.getInstance();
//		LangueManager lm = LangueManager.getInstance();
//		ProprietaireManager pm = ProprietaireManager.getInstance();
//		SiteManager sm = SiteManager.getInstance();
//		VideoManager vm = VideoManager.getInstance();

		// recherche des vidéos correspondant au titre fournit par l'utilisateur
		List<Video> listeVideo = new ArrayList<>();

		listeVideo = LoginController.selectVideosPerTitle(titreFournit);

		// on vérifie si la liste de vidéos obtenues est vide ou pas
		if (listeVideo.isEmpty()) {
			response.getWriter().write("{\"message\":\"<p>Aucune vidéo n'a été trouvée.</p>\"}");
			return;
		}

		List<VideoJSON> listeVideoJSON = new ArrayList<>();
		for (int i = 0; i < listeVideo.size(); i++) {
			VideoJSON videoJSON = new VideoJSON();
			videoJSON.setDuree(listeVideo.get(i).getDurationInSeconds());
			videoJSON.setDescription(listeVideo.get(i).getDescription());
			videoJSON.setTitre(listeVideo.get(i).getTitle());
			videoJSON.setNomChannel(listeVideo.get(i).getChannel());
			videoJSON.setUrlLink(listeVideo.get(i).getUrlLink());
			listeVideoJSON.add(videoJSON);
		}

		// on envoie la liste formattée JSON vers la jsp
		Gson gson = new Gson();
		String jsonListeVideos = gson.toJson(listeVideoJSON);
		response.getWriter().write(jsonListeVideos);
		return;
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		System.out.println("------------------------REST API doPost-----------------------");
//
//		// message à envoyer vers la jsp à la fin
//		String message = "";
//
//		// on crée une nouvelle vidéo dont on rempli les attributs
//		Video video = new Video();
//		video.setDurationInSeconds(Integer.parseInt(request.getParameter("duree")));
//		video.setDescription(request.getParameter("description"));
//		video.setTitle(request.getParameter("titre"));
//
//		// on vérifie si le channel de la video est déjà en base de données. Sinon, on
//		// l'y ajoute
//		Channel channel = cm.selectionnerParNom(request.getParameter("channel"));
//		if (channel.getChannel() == null) {
//			int idChannel = cm.ajouter(new Channel(request.getParameter("channel")));
//			video.setNomChannel(idChannel);
//		} else {
//			video.setNomChannel(channel.getIdChannel());
//		}
//
//		// de même pour le propriétaire
//		Proprietaire proprietaire = pm.selectionnerParNom(request.getParameter("proprietaire"));
//		if (proprietaire.getProprietaire() == null) {
//			int idProprietaire = pm.ajouter(new Proprietaire(request.getParameter("proprietaire")));
//			video.setProprietaire(idProprietaire);
//		} else {
//			video.setProprietaire(proprietaire.getIdProprietaire());
//		}
//
//		// on enregistre la vidéo en base de données
//		vm.ajouter(video);
//		message += "Vidéo enregistrée.";
//
//		response.getWriter().write("<p>" + message + "</p>");
//	}

//	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		System.out.println("------------------------REST API doDelete-----------------------");
//
//		// on cherche l'id de l'utilisateur dans la session
//		HttpSession session = request.getSession();
//		int idUtilisateur = Integer.parseInt(session.getAttribute("idUtilisateur").toString());
//
//		// on supprime la vidéo
//		VideoManager vm = VideoManager.getInstance();
//		try {
//			boolean suppressionReussie = vm.deleteVideo(Integer.parseInt(request.getParameter("idVideo")),
//					idUtilisateur);
//			if (suppressionReussie) {
//				response.getWriter().write("<p>Suppression de la vid�o réussie</p>");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
