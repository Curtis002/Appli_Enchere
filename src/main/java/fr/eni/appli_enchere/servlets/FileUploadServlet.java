package fr.eni.appli_enchere.servlets;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import fr.eni.appli_enchere.bo.ArticleVendu;
import fr.eni.appli_enchere.bo.Utilisateur;
import fr.eni.appli_enchere.dal.ConnectionProvider;
import fr.eni.appli_enchere.dal.DALException;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 1,
		maxFileSize = 1024 * 1024 * 10,
		maxRequestSize = 1024 * 1024 * 100
		)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Part filePart = request.getPart("file");
		System.out.println("filePart : " + filePart );
		String fileName = filePart.getSubmittedFileName();
		System.out.println("fileName : " + fileName );
		
		String savePath = ("/Appli_Enchere/src/main/webapp/img"+File.separator+fileName);
		File fileSaveDirectory = new File (savePath);
		
		filePart.write( savePath + File.separator);
		
		
	
			
		
	
	}

}
