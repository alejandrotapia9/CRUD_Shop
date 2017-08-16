package proyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class OrdenesController {

	private List<Orden> ordenes;	
	private OrdenDB ordendb;
	private HtmlDataTable datatable;
	private Logger logger = Logger.getLogger(getClass().getName());
	

	public OrdenesController() throws Exception {
		ordenes = new ArrayList<>();		
		ordendb = OrdenDB.getInstance();		
	}
	
		
	public HtmlDataTable getDatatable() {
		if (datatable == null) 
		  {
		     datatable = new HtmlDataTable();
		  }
		   return datatable;
	}
	
	
	public void setDatatable(HtmlDataTable datatable) {
		this.datatable = datatable;
	}

	public void setOrdenes(List<Orden> ordenes) {
		this.ordenes = ordenes;
	}


	public List<Orden> getOrdenes() {
		return ordenes;
	}	
	
	public String generarOrden() throws Exception {
		try {
			logger.info("Generando orden");
			FacesContext context = FacesContext.getCurrentInstance();
			Producto data = (Producto) datatable.getRowData();	
			Orden orden = context.getApplication().evaluateExpressionGet(context, "#{orden}", Orden.class);		
			Login log = context.getApplication().evaluateExpressionGet(context, "#{login}", Login.class);
			Producto pr = ProductoDB.getInstance().getProducto(data.getId_producto());
			
			
			
			orden.setCantidad(pr.getCantidadOrden());
			orden.setProducto(pr);
			orden.setUsuario(log.getUs().getId());
			
			ordendb.addOrden(orden);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error agregando orden", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			return null;
		}
		
		return "consumidor";
		
	}

	public void addOrden(Orden orden) throws Exception {

		logger.info("Agregando orden");
		
		
	
		try {
			
			ordendb.addOrden(orden);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error agregando orden", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
		}
		
		
	}

	public void loadOrdenes() {
	
		logger.info("Cargando ordenes");
		
		ordenes.clear();
	
		try {
			
			// get all users from database
			ordenes = ordendb.getOrdenes();
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error cargando Productos", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
		}
	}
	

	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
