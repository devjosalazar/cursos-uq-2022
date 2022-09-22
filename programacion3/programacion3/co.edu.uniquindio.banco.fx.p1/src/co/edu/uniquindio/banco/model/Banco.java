package co.edu.uniquindio.banco.model;

import java.io.Serializable;
import java.util.ArrayList;

import co.edu.uniquindio.banco.exceptions.EmpleadoException;
import co.edu.uniquindio.banco.model.services.IBancoService;

public class Banco implements IBancoService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<Cliente> listaClientes = new ArrayList<>();
	ArrayList<Empleado> listaEmpleados = new ArrayList<>();
	ArrayList<Cuenta> listaCuentas = new ArrayList<>();
	ArrayList<Transaccion> listaTransaccionesAsociadas = new ArrayList<Transaccion>();
	
	public Banco() {
		
	}
	

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}
	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public ArrayList<Cuenta> getListaCuentas() {
		return listaCuentas;
	}


	public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}


	public ArrayList<Transaccion> getListaTransaccionesAsociadas() {
		return listaTransaccionesAsociadas;
	}


	public void setListaTransaccionesAsociadas(ArrayList<Transaccion> listaTransaccionesAsociadas) {
		this.listaTransaccionesAsociadas = listaTransaccionesAsociadas;
	}


	@Override
	public Empleado crearEmpleado(String nombre, String apellido, String cedula, String fechaNacimiento) {
		
		//1. verificar si existe
		boolean empleadoExiste = false;
		
		if(empleadoExiste == true){
			return null;
		}else{
			Empleado nuevoEmpleado = new Empleado();
			nuevoEmpleado.setNombre(nombre);
			nuevoEmpleado.setApellido(apellido);
			nuevoEmpleado.setCedula(cedula);
			nuevoEmpleado.setFechaNacimiento(fechaNacimiento);
		}
		return null;
	}


	@Override
	public boolean actualizarEmpleado(String cedulaActual, String nombre, String apellido, String cedula,
			String fechaNacimiento) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Boolean eliminarEmpleado(String cedula) throws EmpleadoException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean verificarEmpleadoExistente(String cedula) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Empleado obtenerEmpleado(String cedula) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<Empleado> obtenerEmpleados() {
		// TODO Auto-generated method stub
		return getListaEmpleados();
	}






	
	
	

}
