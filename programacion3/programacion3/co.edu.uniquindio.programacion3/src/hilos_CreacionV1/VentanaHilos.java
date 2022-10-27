package hilos_CreacionV1;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Group;

public class VentanaHilos extends ApplicationWindow {

	/**
	 * Create the application window.
	 */
	static ManejadorHilo manejadorHilo;
	
	
	public VentanaHilos() {
		super(null);
		createActions();
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();
	}

	/**
	 * Create contents of the application window.
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		
		Button btnMain1 = new Button(container, SWT.NONE);
		btnMain1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				System.out.println("Ejecución Main 1");
				
			}
		});
		btnMain1.setBounds(56, 39, 75, 25);
		btnMain1.setText("Main1");
		
		Button btnMain_2 = new Button(container, SWT.NONE);
		btnMain_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				for (int i = 0; i < 10; i++) {
					
					try {
						Thread.sleep(700);
						System.out.println("Ejecución Main 2");
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				
				
			}
		});
		btnMain_2.setBounds(159, 39, 75, 25);
		btnMain_2.setText("Main2");
		
		Button btnMain_3 = new Button(container, SWT.NONE);
		btnMain_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				System.out.println("Ejecución Main 3");
			}
		});
		btnMain_3.setBounds(273, 39, 75, 25);
		btnMain_3.setText("Main3");
		
		Label lblFlujoPrincipal = new Label(container, SWT.NONE);
		lblFlujoPrincipal.setBounds(10, 18, 100, 15);
		lblFlujoPrincipal.setText("Flujo principal:");
		
		Group grpHilosServiciosPropios = new Group(container, SWT.NONE);
		grpHilosServiciosPropios.setText("Hilos servicios propios");
		grpHilosServiciosPropios.setBounds(10, 95, 252, 314);
		
		Group grpHiloServicio = new Group(grpHilosServiciosPropios, SWT.NONE);
		grpHiloServicio.setText("Hilo servicio 1");
		grpHiloServicio.setBounds(10, 33, 232, 82);
		
		Button btnStart = new Button(grpHiloServicio, SWT.NONE);
		btnStart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				manejadorHilo.starHiloServicio1();
			}
		});
		btnStart.setBounds(10, 36, 75, 25);
		btnStart.setText("Start");
		
		Button btnStop = new Button(grpHiloServicio, SWT.NONE);
		btnStop.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				manejadorHilo.detenerHiloServicio1();
			}
		});
		btnStop.setBounds(118, 36, 75, 25);
		btnStop.setText("Stop");
		
		Group grpHiloServicio_1 = new Group(grpHilosServiciosPropios, SWT.NONE);
		grpHiloServicio_1.setText("Hilo servicio 2");
		grpHiloServicio_1.setBounds(10, 131, 232, 82);
		
		Button btnStart_1 = new Button(grpHiloServicio_1, SWT.NONE);
		btnStart_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				manejadorHilo.starHiloServicio2();
			}
		});
		btnStart_1.setBounds(10, 31, 75, 25);
		btnStart_1.setText("Start");
		
		Button btnStop_1 = new Button(grpHiloServicio_1, SWT.NONE);
		btnStop_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				manejadorHilo.detenerHiloServicio2();
			}
		});
		btnStop_1.setBounds(122, 31, 75, 25);
		btnStop_1.setText("Stop");
		
		Group grpHiloServicio_2 = new Group(grpHilosServiciosPropios, SWT.NONE);
		grpHiloServicio_2.setBounds(10, 222, 232, 82);
		grpHiloServicio_2.setText("Hilo servicio 3");
		
		Button btnStart_2 = new Button(grpHiloServicio_2, SWT.NONE);
		btnStart_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				manejadorHilo.starHiloServicio3();
			}
		});
		btnStart_2.setBounds(10, 36, 75, 25);
		btnStart_2.setText("Start");
		
		Button btnStop_2 = new Button(grpHiloServicio_2, SWT.NONE);
		btnStop_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				manejadorHilo.detenerHiloServicio3();
			}
		});
		btnStop_2.setBounds(122, 36, 75, 25);
		btnStop_2.setText("Stop");

		return container;
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}



	/**
	 * Create the status line manager.
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			VentanaHilos window = new VentanaHilos();
			window.setBlockOnOpen(true);
			manejadorHilo = new ManejadorHilo();
			window.open();
			Display.getCurrent().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Configure the shell.
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Ventana Hilos");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(674, 504);
	}
}
