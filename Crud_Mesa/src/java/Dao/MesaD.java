package Dao;

import Interfaces.MesaI;
import Modelo.MesaM;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MesaD extends Conexion implements MesaI {

    @Override
    public void registrar(MesaM mesa) throws Exception {
        try {
            this.Conexion();
            String sql = "insert into MESA (NUM_MESA,CANT_SILLA_MESA,EST_MESA) VALUES (?,?,?)";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, mesa.getNUM_MESA());
            st.setString(2, mesa.getCANT_SILLAS_MESA());
            st.setString(3, "A");
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<MesaM> listar() throws Exception {
        List<MesaM> lista;
        ResultSet rs;
        try {
            this.Conexion();
            String sql = "SELECT * FROM MESA";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                MesaM mesa = new MesaM();
                mesa.setCOD_MESA(rs.getString("COD_MESA"));
                mesa.setNUM_MESA(rs.getString("NUM_MESA"));
                mesa.setCANT_SILLAS_MESA(rs.getString("CANT_SILLA_MESA"));
                mesa.setESTADO(rs.getString("EST_MESA"));
                lista.add(mesa);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
   

    @Override
    public void modificar(MesaM dat) throws Exception {
        try {
            this.Conexion();
            String sql = "update MESA set NUM_MESA=?, CANT_SILLA_MESA=?, EST_MESA=? where COD_MESA=?";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            st.setString(1, dat.getNUM_MESA());
            st.setString(2, dat.getCANT_SILLAS_MESA());
            st.setString(3, dat.getESTADO());
            st.setString(4, dat.getCOD_MESA());
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
   

}
