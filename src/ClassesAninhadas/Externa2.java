package ClassesAninhadas;

public class Externa2 {
	public void MetodoQualquer() {

		class ClassLocal{
			
			private String texto = "um texto qualquer";
			
			public void imprimeTexto() {
				System.out.println(texto);
			}
		}
		
		ClassLocal local = new ClassLocal();
		
		local.imprimeTexto();
	}
	
	public static void main(String[] args) {
		
		Externa2 externa = new Externa2();
		externa.MetodoQualquer();
	}
}
