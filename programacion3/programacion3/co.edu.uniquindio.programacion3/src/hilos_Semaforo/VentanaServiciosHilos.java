package hilos_Semaforo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

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
		
		Group grpHilosPropios = new Group(composite, SWT.NONE);
		grpHilosPropios.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpHilosPropios.setText("Hilos propios");
		grpHilosPropios.setBounds(10, 10, 228, 300);
		
		Group grpServicio = new Group(grpHilosPropios, SWT.NONE);
		grpServicio.setBounds(10, 23, 201, 82);
		grpServicio.setText("Servicio 1: Contar 1 en 1");
		
		Button btnStart = new Button(grpServicio, SWT.NONE);
		btnStart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				manejadorServicios.startHiloServicio1();
				
			}
		});
		btnStart.setBounds(10, 36, 75, 25);
		btnStart.setText("Start");
		
		Button btnStop = new Button(grpServicio, SWT.NONE);
		btnStop.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				manejadorServicios.detenerHiloServicio1();
			}
		});
		btnStop.setBounds(104, 36, 75, 25);
		btnStop.setText("Stop");
		
		Group grpServicio_1 = new Group(grpHilosPropios, SWT.NONE);
		grpServicio_1.setBounds(10, 111, 201, 82);
		grpServicio_1.setText("Servicio 2: Contar 5 en 5");
		
		Button btnStart_1 = new Button(grpServicio_1, SWT.NONE);
		btnStart_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				manejadorServicios.startHiloServicio2();
			}
		});
		btnStart_1.setBounds(10, 34, 75, 25);
		btnStart_1.setText("Start");
		
		Button btnStop_1 = new Button(grpServicio_1, SWT.NONE);
		btnStop_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				manejadorServicios.detenerHiloServicio2();
			}
		});
		btnStop_1.setBounds(105, 34, 75, 25);
		btnStop_1.setText("Stop");
		
		Group grpServicio_2 = new Group(grpHilosPropios, SWT.NONE);
		grpServicio_2.setBounds(10, 199, 201, 89);
		grpServicio_2.setText("Servicio 3: Contar 10 en 10");
		
		Button btnStart_2 = new Button(grpServicio_2, SWT.NONE);
		btnStart_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				manejadorServicios.startHiloServicio3();

			}
		});
		btnStart_2.setBounds(10, 43, 75, 25);
		btnStart_2.setText("Start");
		
		Button btnStop_2 = new Button(grpServicio_2, SWT.NONE);
		btnStop_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				manejadorServicios.detenerHiloServicio3();
			}
		});
		btnStop_2.setBounds(105, 43, 75, 25);
		btnStop_2.setText("Stop");
		
		Group grpHilosNoPropios = new Group(composite, SWT.NONE);
		grpHilosNoPropios.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpHilosNoPropios.setText("Hilos NO propios");
		grpHilosNoPropios.setBounds(284, 10, 214, 300);
		
		Group grpServicio_3 = new Group(grpHilosNoPropios, SWT.NONE);
		grpServicio_3.setText("Servicio 4: Multiplicar por");
		grpServicio_3.setBounds(10, 25, 194, 74);
		
		Button btnStart_3 = new Button(grpServicio_3, SWT.NONE);
		btnStart_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				try {
					manejadorServicios.startHiloServicio4(Integer.valueOf(textValorEntrada.getText()));
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
		grpServicioSuma.setText("Servicio 5: Suma valor entrada");
		grpServicioSuma.setBounds(10, 116, 194, 55);
		
		Button btnStart_4 = new Button(grpServicioSuma, SWT.NONE);
		btnStart_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				manejadorServicios.startHiloServicio5();
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
