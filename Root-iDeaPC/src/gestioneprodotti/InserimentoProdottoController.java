package gestioneprodotti;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



/**
 * InserimentoProdottoController
 * Servlet che inserisce un prodotto nel database
 */
@WebServlet("/InserimentoProdottoController")
public class InserimentoProdottoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProdottoDS prodottods = new ProdottoDS();
	// location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "images";
    
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    private ArrayList<String> parametri;
	
	private String nome;
	private String descrizione;
	private double prezzo; 
	private int quantita;
	private String immagine;
	private String immagineOriginale;
	private Prodotto p;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserimentoProdottoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		prendiParametri(request, response);
		creaProdotto(request, response);
		
		try{
			prodottods.insert(p);
		}catch(Exception e){
			e.printStackTrace();
		}
		
			
		}
		
	

	private void prendiParametri(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (!ServletFileUpload.isMultipartContent(request)) {
			// if not, we stop here
			  PrintWriter writer = response.getWriter();
	            writer.println("Error: Form must has enctype=multipart/form-data.");
	            writer.flush();
	            return;
		}
		parametri = new ArrayList<String>();
        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);
        
     // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);
 
        // constructs the directory path to store upload file
        // this path is relative to application's directory
        String uploadPath = getServletContext().getRealPath("/")
                + "/" + UPLOAD_DIRECTORY;
        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
            System.out.println("creata cartella");
        }
 
        try {
            // parses the request's content to extract file data
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
 
            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems)
                {
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + "/" + fileName;
                        File storeFile = new File(filePath);
                        parametri.add("images/"+fileName);
                        // saves the file on disk
                        item.write(storeFile);
                    }
                    else
                    {
                    	parametri.add(item.getString());
                    }
                }
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        	
        }
        
        
    	private void creaProdotto(HttpServletRequest request, HttpServletResponse response) {
    		
 		   	immagine = parametri.get(0);
 		   	immagineOriginale = parametri.get(1);
 		   	nome = parametri.get(2);
 		   	descrizione = parametri.get(2);
 		   	prezzo = Double.parseDouble(parametri.get(3));
 		   	quantita = Integer.parseInt(parametri.get(4));
 		   	System.out.println(parametri.size());
 		   	System.out.println(parametri.get(0));
 		   	System.out.println(parametri.get(1));
 		   	System.out.println(parametri.get(2));
 		   	System.out.println(parametri.get(3));
 		   	System.out.println(parametri.get(4));
 		   	
 		   	p = new Prodotto();
 		   	p.setDescrizione(descrizione);
 		   	p.setImmagine(immagine);
 		   	p.setNome(nome);
 		   	p.setQuantit�(quantita);
 		   	p.setPrezzo(prezzo);
// 		    nome = request.getParameter("nome");
//			descrizione = request.getParameter("descrizione");
//			prezzo = Double.parseDouble(request.getParameter("prezzo"));
//			quantita =Integer.parseInt(request.getParameter("quantita"));
			p = new Prodotto(1, nome , descrizione , prezzo, immagine , quantita);
 		   
// 	        nome = parametri.get(1);
// 	        descrizione = parametri.get(2);
// 	        prezzo = Double.parseDouble(parametri.get(3));
// 	        quantita = Integer.parseInt(parametri.get(4));
// 	        
// 	        p = new Prodotto();
// 	        p.setImmagine(immagine);
// 	        p.setNome(nome);
// 	        p.setDescrizione(descrizione);
// 	        p.setPrezzo(prezzo);
// 	        p.setQuantit�(quantita);	
 	}

		
	}

        		
        		
//				
//				RequestDispatcher view = request.getRequestDispatcher("gestione-prodotto.jsp");
//				view.forward(request, response);
	
	


