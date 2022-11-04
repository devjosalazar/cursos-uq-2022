package hilos_taller;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;

public class VentanaServiciosHilos {

	protected Shell shlHilos;
	static ManejadorHilos manejadorServicios;
	private Text textValorEntrada;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			VentanaServiciosHilos window = new VentanaServiciosHilos();
			
			manejadorServicios = new ManejadorHilos();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlHilos.open();
		shlHilos.layout();
		while (!shlHilos.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlHilos = new Shell();
		shlHilos.setSize(632, 438);
		shlHilos.setText("Hilos");
		
		Composite composite = new Composite(shlHilos, SWT.NONE);
		composite.setBounds(10, 10, 603, 371);
		
		Group grpHilosNoPropios = new Group(composite, SWT.NONE);
		grpHilosNoPropios.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpHilosNoPropios.setText("Hilos NO propios");
		grpHilosNoPropios.setBounds(10, 10, 214, 300);
		
		Group grpServicio_3 = new Group(grpHilosNoPropios, SWT.NONE);
		grpServicio_3.setText("Servicio 1");
		grpServicio_3.setBounds(10, 25, 194, 74);
		
		Button btnStart_3 = new Button(grpServicio_3, SWT.NONE);
		btnStart_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				try {
					manejadorServicios.startHiloServicio1(textValorEntrada.getText());
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnStart_3.setBounds(10, 33, 75, 25);
		btnStart_3.setText("Start");
		
		textValorEntrada = new Text(grpServicio_3, SWT.BORDER);
		textValorEntrada.setBounds(93, 33, 91, 25);
		
		Group grpServicioSuma = new Group(grpHilosNoPropios, SWT.NONE);
		grpServicioSuma.setText("Servicio 2");
		grpServicioSuma.setBounds(10, 116, 194, 55);
		
		Button btnStart_4 = new Button(grpServicioSuma, SWT.NONE);
		btnStart_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				manejadorServicios.startHiloServicio2();
			}
		});
		btnStart_4.setBounds(10, 20, 75, 25);
		btnStart_4.setText("Start");
		
		Button btnStop_3 = new Button(grpHilosNoPropios, SWT.NONE);
		btnStop_3.setBounds(10, 187, 75, 25);
		btnStop_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				manejadorServicios.detenerHilo();
			}
		});
		btnStop_3.setText("Stop");

	}
}
