package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class daoUsuario extends conexion {

    public usuario identificar(usuario user) throws Exception {
        usuario usu = null;
        conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select u.idusuario, c.nombrecargo from usuario u inner join cargo c on u.`IDCARGO` = c.`IDCARGO`\n"
                + "where u.estado = 1 and u.`NOMBREUSUARIO` = '" + user.getNombreUsuario() + "' and u.`CLAVE` = '" + user.getClave() + "'";
        con = new conexion();

        try {
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next() == true) {
                usu = new usuario();  
                usu.setIdUsuario(rs.getInt("idusuario"));
                usu.setNombreUsuario(user.getNombreUsuario());
                usu.setCargo(new cargo());
                usu.getCargo().setNombreCargo(rs.getString("nombrecargo"));
                usu.setEstado(true);
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }finally{
            if (rs != null && rs.isClosed() == false){
                rs.close();
            }
            rs = null;
            if(st!=null && st.isClosed()==false){
                st.close();
            }
            st = null;
            if(cn!=null && cn.isClosed()== false){
                cn.close();
            }
            cn= null;
        }
        return usu;
    }
}
