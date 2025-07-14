import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		// para probar git
		int numeroX = 10;
		System.out.println(numeroX);
		
		Scanner lectura = null;
		
		// declarar las variables
		String matricula;
		String nombre;
		long numCel;
		String genero;
		
		Alumnos alumno; 
		
		List<Alumnos> registrosLista = new ArrayList<Alumnos>();
		
		int menuPrincipal, subMenu, indice;
		
		//menu principal
	
		do {
			System.out.println("Bienvenido al sistema");
			System.out.println("1 -> Alta");
			System.out.println("2 -> Mostrar");
			System.out.println("3 -> Buscar");
			System.out.println("4 -> Editar");
			System.out.println("5 -> Eliminar");
			System.out.println("6 -> Buscar por nombre del alumno");
			System.out.println("7 -> Buscar por genero");
			System.out.println("8 -> Eliminar alumnos buscando por nombre");
			System.out.println("9 -> Salir");
			
			lectura = new Scanner(System.in);
			menuPrincipal = lectura.nextInt();
			
			switch (menuPrincipal) {
			case 1:
				try {
					System.out.println("ingrese la matricula");
					lectura = new Scanner (System.in);
					matricula = lectura.nextLine();
					
					System.out.println("ingrese el nombre");
					lectura = new Scanner (System.in);
					nombre = lectura.nextLine();
					
					System.out.println("ingrese el numero de celular");
					lectura = new Scanner (System.in);
					numCel = lectura.nextLong();
					
					System.out.println("ingrese el genero");
					lectura = new Scanner (System.in);
					genero = lectura.nextLine();
					
					// crear el objeto con todos los atributos
					alumno = new Alumnos(matricula, nombre, numCel, genero);
					
					// agregar el objeto  la lista 
					registrosLista.add(alumno);
					System.out.println("\nSe agrego el alumno\n");
				} catch (Exception e) {
					System.out.println("Error al guardar" + e.getMessage());
					// TODO: handle exception
				}
				break;

			case 2:
				System.out.println(registrosLista);
				break;

			case 3:
				try {
					if (registrosLista.size() > 0) {
						System.out.println("ingrese el indice del resgitro a buscar");
						lectura = new Scanner (System.in);
						indice = lectura.nextInt();
					
						//buscar 
					
						alumno = registrosLista.get(indice);
						System.out.println("se encontro el registro: "+ alumno);
					}else
						System.out.println("no hay registros en la lista");
				
				}catch (Exception e) {
					System.out.println("No hay registros en la lista"+ e.getMessage());
				}
				
				break;
				
			case 4:
				try {
					if (registrosLista.size() > 0) {
						
						System.out.println("Ingrese el indice del registro a editar");
						lectura = new Scanner (System.in);
						indice = lectura.nextInt();
					
						//buscar 
						alumno = registrosLista.get(indice);
						System.out.println("Se encontro el alumno: " + alumno.getNombre());
						
						do {
							System.out.println("Submenu para editar");
							System.out.println("1--nombre");
							System.out.println("2--telefono");
							System.out.println("3-- Regresar");
							
							lectura = new Scanner (System.in);
							subMenu = lectura.nextInt();
							
							switch (subMenu) {
							case 1:
								System.out.println("ingrese el nuevo nombre:");
								lectura = new Scanner (System.in);
								nombre = lectura.nextLine();
								
								// actualizar el objeto
								alumno.setNombre(nombre);
								System.out.println("Se edito el nombre con exito");
								break;

							case 2:
								System.out.println("ingrese el nuevo numero de telefono:");
								lectura = new Scanner (System.in);
								numCel = lectura.nextLong();
								numCel = lectura.nextLong();
								
								// actualizar el objeto
								alumno.setNumCel(numCel);
								System.out.println("Se edito el numero con exito");
								break;
							
							case 3:
								
								break;
							}
							
						} while (subMenu < 3);
						
						
					}else
						System.out.println("No hay registros en la lista");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("No existe ese registro");
				}
				
				break;
				
			case 5: 
				try {
					
					System.out.println("ingrese el indice a eliminar");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();
					
					// eliminar 
					registrosLista.remove(indice);
					System.out.println("Se elimino el registro con exito");
				} catch (Exception e) {
				
					// TODO: handle exception
					System.out.println("no existe ese registro");
				}
				break;
				
				// buscar por nombre del alumno
			case 6:
				try {
					if (registrosLista.size() > 0) {
						System.out.println("Ingrese el nombre del alumno a buscar:");
					
						lectura = new Scanner(System.in);
						String nombreBuscado = lectura.nextLine();
						boolean encontrado = false;
						
						for (int i = 0; i < registrosLista.size() ; i++) {
							Alumnos alumnoActual = registrosLista.get(i);
							
							if (alumnoActual.getNombre().equals(nombreBuscado)) {
								System.out.println("Alumno encontrado: " + alumnoActual);
								encontrado = true;
							}
						}
						if (encontrado != true) {
							System.out.println("No se encontro ningun alumno con ese nombre.");
						}
						
				
					}	
					
					
					} catch (Exception e) {
					// TODO: handle exception
					System.out.println("\nNo hay registros o error al ingresar el dato");
					}
			
				
				
				break;	
				//buscar por genero
			case 7: 
				
				try {
					if (registrosLista.size() > 0) {
						
						System.out.println("Ingrese el genero para buscar:");				
						lectura = new Scanner(System.in);
						String generoBuscado = lectura.nextLine();
						boolean encontrado = false;

						for (int i = 0; i < registrosLista.size() ; i++) {
							Alumnos generoActual = registrosLista.get(i);
							
							if (generoActual.getGenero().equals(generoBuscado)) {
								System.out.println("Alumnos con genero encontrado: " + generoActual);
								encontrado = true;
								
							}
						}
						if (encontrado != true){
							System.out.println("No se encontro ningun alumno con ese genero.");
						}
				
					}	
					} catch (Exception e) {
					// TODO: handle exception
					System.out.println("\nError al ingresar el dato");
					}
				break;
				
				
				
				// eliminar por nombre
			case 8: 
				try {
					if (registrosLista.size() > 0) {
						System.out.println("Ingrese el nombre para eliminar:");
					
						lectura = new Scanner(System.in);
						String nombreEliminar = lectura.nextLine();
					
						for (int i = 0; i < registrosLista.size(); i++) {
							Alumnos alumnoActual = registrosLista.get(i);
							
							if (alumnoActual.getNombre().equals(nombreEliminar)) {
								registrosLista.remove(i);
								System.out.println("Alumno eliminado con exito ");
								
							}
						}
				
					}	
					} catch (Exception e) {
					// TODO: handle exception
					System.out.println("\nError al ingresar el dato");
					}
				break;
				// salir
			case 9:	
				System.out.println("Saliendo del sistema");
				break;
				
			}
			

			
			
			// las condiciones trabajano con valores booleanos -> true o false
		}while(menuPrincipal < 9);
	
		
	
	}
}
