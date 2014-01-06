package resource;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

import data.DAOChild;
import data.IDAOChild;

import model.Child;
import model.Present;

@Path("/")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class PresentResource extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id = new Long(request.getParameter("id")).longValue();
		
		if(request.getParameter("isNaughty").equals("naughty")) {
			this.naughty(id);
		}
		if(request.getParameter("isNaughty").equals("good")) {
			this.good(id);
			if(request.getParameter("isValid").equals("yes")) {
				this.validate(id, new Long(1));
			}
		}
		response.sendRedirect("main.jsp");
	}
	
	@GET
	@Path("Children/{child}/{city}")
	@Produces({"application/xml", "application/json"})
	public Response get(@PathParam("child") String child,
			@PathParam("city") String city) {
		IDAOChild dao = new DAOChild();
		Present p = dao.getChildCriteria(child, city);

		return Response.ok(p).build();
	}
	
    @POST
    @Path("Children/{child}/{city}/{present}")
    public Response post(@PathParam("child") String child, 
    		@PathParam("city") String city, @PathParam("present") String present) {
    	Child c = new Child();
		c.setName(child);
		c.setCity(city);
		c.setIsNaughty(false);
		
		Present pr = new Present();
		pr.setName(present);
		
    	IDAOChild dao = new DAOChild();
		dao.addChild(c, pr);
    	
		return Response.status(Status.CREATED).build();
    }
    
    @GET
	@Path("Santa/Stock/Children/")
	@Produces({"application/xml", "application/json"})
	public Response getAll() {
		IDAOChild dao = new DAOChild();
		List<Child> childrenList = dao.getStock();
	
		return Response.ok(childrenList).build();
	}
	
	@GET
	@Path("Santa/Stock/Children/{id}")
	@Produces({"application/xml", "application/json"})
	public Response get(@PathParam("id") long id) {
		IDAOChild dao = new DAOChild();
		Child child = dao.getChild(id);
		if(child==null) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			return Response.ok(child).build();	
		}
		
	}
	
	@PUT
	@Path("Santa/Stock/Children/{idChild}/NAUGHTY")
	public Response naughty(@PathParam("idChild") long idChild) {
		IDAOChild dao = new DAOChild();
		Child child = dao.updateChildNaughty(idChild, true);
		if(child == null) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			return Response.ok(child).build();	
		}
	}
	
	@PUT
	@Path("Santa/Stock/Children/{idChild}/GOOD")
	public Response good(@PathParam("idChild") long idChild) {
		IDAOChild dao = new DAOChild();
		Child child = dao.updateChildNaughty(idChild, false);
		if(child == null) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			return Response.ok(child).build();	
		}
	}
	
	@GET
	@Path("Santa/Stock/Children/{idChildren}/Present/{idPresent}")
	@Produces({"application/xml", "application/json"})
	public Response get(@PathParam("idChildren") long idChild, @PathParam("isPresent") long idPresent) {
		IDAOChild dao = new DAOChild();
		Child child = dao.getChild(idChild);
		
		if(child == null) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			Present p = child.getPresent();
			return Response.ok(p).build();
		}
	}

	@PUT
	@Path("Santa/Stock/Children/{idChild}/Present/{idPresent}/OK")
	public Response validate(@PathParam("idChild") long idChild, 
			@PathParam("idPresent") long idPresent) {
		IDAOChild dao = new DAOChild();
		Child child = dao.approveChildPresent(idChild, idPresent);
		
		if(child == null) {
			return Response.status(Status.NOT_ACCEPTABLE).build();
		} else {
			return Response.ok(child).build();
		}
	}

}