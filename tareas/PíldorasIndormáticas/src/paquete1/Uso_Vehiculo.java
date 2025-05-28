package paquete1;



public class Uso_Vehiculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Coche coche1 = new Coche();
		
		coche1.establece_color("Rojo");
		
		Furgoneta furgo1 = new Furgoneta(7, 580);
		
		furgo1.establece_color("Amarillo");
		
		furgo1.configura_asientos("Si");
		
		furgo1.configura_climatizador("Si");
		
		System.out.println(coche1.dime_datos_generales()+
				" "+coche1.dime_color());
		
		System.out.println(furgo1.dime_datos_generales()+
				" "+furgo1.dime_color()+" \n"
				+furgo1.getDatosFurgoneta());

	}

}
