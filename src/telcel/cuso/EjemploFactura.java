package telcel.cuso;

import telcel.curso.modelo.*;

import java.util.*;
public class EjemploFactura {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setRfc("BARN8809264U1");
		cliente.setNombre("Nahum");
		
		Scanner view = new Scanner(System.in);
		
		System.out.println("Ingrese una descripción de la factura");
		String desc = view.nextLine();
		
		Factura factura = new Factura(desc, cliente);
		
		Producto producto; 
		
		String nombre;
		float precio;
		int cantidad; 
		
		System.out.println();
		
		for(int i =  0 ; i<5;i++) {
			producto = new Producto();
			System.out.print("Ingrese producto n " + producto.getCodigo() + ":");
			nombre = view.next();
			producto.setNombre(nombre);
			
			System.out.print("Ingrese precio: ");
			precio = view.nextFloat();
			producto.setPrecio(precio);
			
			
			System.out.print("Ingrese cantidad: ");
			cantidad = view.nextInt();
			ItemFactura item = new ItemFactura(cantidad, producto);
			factura.addItemFactura(item);
			
			
			System.out.println();
			
		}
		
		System.out.println(factura.generarDetalle());
	}

}
