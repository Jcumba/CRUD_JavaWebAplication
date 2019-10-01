package Interfaces;

import Modelo.MesaM;
import java.util.List;


public interface MesaI {

    public void registrar(MesaM mesa) throws Exception;

    public List<MesaM> listar() throws Exception;

    public void modificar(MesaM dat) throws Exception;

}
