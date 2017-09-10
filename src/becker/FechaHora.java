package becker;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
*
*
*/
public class FechaHora {
    

private Date date = new Date();


        public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    


 


public String Hora (){
  String llegada;
//Caso 1: obtener la hora y salida por pantalla con formato:
DateFormat hourFormat = new SimpleDateFormat("HH.mm");

System.out.println("Hora: "+hourFormat.format(date));
llegada = hourFormat.format(date);
return llegada;
}

public String Fecha (){
    String Fsalida = "";
//Caso 2: obtener la fecha y salida por pantalla con formato:
DateFormat dateFormat = new SimpleDateFormat("dd.MM");
System.out.println("Fecha: "+dateFormat.format(date));
Fsalida = dateFormat.format(date);
return Fsalida;
}


public float Cobro (String llegada, String salida, String Fsalida){
  float numero, numero1, total, pagar ;
float fecha;     
    numero1 =Float.parseFloat(salida);
    System.out.println(""+ numero1);
    numero = Float.parseFloat(llegada);
    System.out.println(""+numero + " "+ Fsalida);
    
    fecha = Float.parseFloat(Fsalida);
    total = numero1 - numero;
    pagar = (total * 10000) / 1 ;

        
    
      return pagar;
}




}