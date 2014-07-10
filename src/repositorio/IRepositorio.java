/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repositorio;

import java.util.List;
import java.util.Map;

/**
 *
 * @author luis
 */
public interface IRepositorio <T> {
    
    public List<T> get(Class<T> tipo);
    public T get(Class<T> tipo,int id);
    public void add(T objeto);
    public void delete(T objeto);
    public void update(T objeto);
    public void conectar();
    public void desconectar();
    public List<T> find(String consulta
            ,Map<String,Object> params);
}
