package telcel.curso.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
	
	private int folio; 
	private String descripcion; 
	private Date fecha;
	
	private Cliente cliente; 
	private ItemFactura [] items; 
	private int indiceItems; 
	private static final int MAX_ITEMS = 12;
	
	private static int ultimoFolio;
	
	
	
	public Factura(String descripcion, Cliente cliente) {		
		this.descripcion = descripcion;
		this.cliente = cliente;
		this.items = new ItemFactura[MAX_ITEMS];
		this.folio = ++ultimoFolio;
		this.fecha = new Date();
	}
	
	
	public int getFolio() {
		return folio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public Date getFecha() {
		return fecha;
	}	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public ItemFactura[] getItems() {
		return items;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setItems(ItemFactura[] items) {
		this.items = items;
	}
	
	
	public void addItemFactura(ItemFactura item) {
		if(indiceItems < MAX_ITEMS) {
			this.items[indiceItems++] = item;
		}
		
	}
	
	public float calcularTotal() {
		float total = 0.0f;		
		for(ItemFactura item: this.items) {
			if(item == null) {
				continue; 
			}
			total += item.calulcarImporte();
		}		
		return total; 
	}
	
	public String generarDetalle() {
		StringBuilder sb = new StringBuilder("Factura No: " + folio);
		float sumaTotal = 0;
		sb.append(folio).
		append("\nCliente: ").append(this.cliente.getNombre()).
		append("\t RFC: ").append(this.cliente.getRfc()).
		append("\t Descripcion: ").append(this.descripcion).append("\n").
		append("\n#\tNombre\t$\tCantidad.\tTotal\n");
		
		SimpleDateFormat df = new SimpleDateFormat("dd'de'MMMM,yyyy");
		sb.append("Fecha Emision: ").append(df.format(this.fecha)).append("\n");
		
		for(ItemFactura item: this.items) {
			if(item == null) {
				continue;
			}
			sb.append(item.getProducto().getCodigo()).append("\t")
			.append(item.getProducto().getNombre()).append("\t")
			.append(item.getProducto().getPrecio()).append("\t")
			.append(item.getCantidad()).append("\t")
			.append(item.calulcarImporte()).append("\n");
			
			sumaTotal = sumaTotal + item.calulcarImporte();
		}
		
		sb.append("\n Gran Total: " + sumaTotal);
		
		return sb.toString();
	}

}
