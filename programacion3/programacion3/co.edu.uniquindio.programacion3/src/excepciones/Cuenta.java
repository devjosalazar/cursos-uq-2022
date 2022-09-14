package excepciones;

import javax.swing.JOptionPane;

public class Cuenta {

	double saldo;
	public Cuenta()
	 {
	     saldo= 0;
	}
	public void ingresar(double c)
	{
	     saldo+=c;
	}
	
	public void extraer( double c) throws CuentaException
	{
	   if(saldo<c)
		throw new CuentaException("Saldo insuficiente");
	   else
		saldo-=c;
	}
	
	
	public double getSaldo()
	{
		return saldo;
	}

	
	
}
