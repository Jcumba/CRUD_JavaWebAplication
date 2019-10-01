package Controlador;

import Dao.MesaD;
import Modelo.MesaM;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;

@Named(value = "mesaC")
@SessionScoped
@Data
public class MesaC implements Serializable {

    private MesaM mesa = new MesaM();
    private List<MesaM> lstMesa;
    private MesaM selectmes;
    private String accion;

    public void operar() throws Exception {
        switch (accion) {
            case "Registrar":
                this.registrar();
                break;
            case "Modificar":
                this.modificar();
                break;
        }
    }
    
     @PostConstruct
    public void init() {
        try {
           listar();
        } catch (Exception ex) {
        }
    }

    public void registrar() throws Exception {
        MesaD Dao;
        try {
            Dao = new MesaD();
            Dao.registrar(mesa);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AGREGADO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR"));
            throw e;
        }
    }

    public void modificar() throws Exception {
        MesaD Dao;
        try {
            Dao = new MesaD();
            Dao.modificar(selectmes);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ACTUALIZADO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR", "AL ACTUALIZAR"));
            throw e;
        }
    }

    public void listar() throws Exception {
        MesaD dao;
        try {
            dao = new MesaD();
            lstMesa = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

   

    public void limpiar() {
        mesa = new MesaM();

    }
}
