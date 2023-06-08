
package Modelo;


public class comprobar {
    public static void main(String[] args) {
        conexion cn= new conexion();
        if(cn.conectar()!=null){
            System.out.println("Conexion es correcta");
        }else{
            System.out.println("Conexion erronea");
        }
    }
}
