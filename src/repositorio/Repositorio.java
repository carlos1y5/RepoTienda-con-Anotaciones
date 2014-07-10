/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repositorio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author luis
 */
public class Repositorio<T> implements IRepositorio<T>{

    protected Session sesion;

    public Repositorio() {
        conectar();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
        desconectar();
    }
     
    
    
    @Override
    public List<T> get(Class<T> tipo) {
      
        Query consulta=sesion.createQuery("from "+
                 tipo.getName());
        List<T> lista=consulta.list();
        
        return lista;
    
    }

    @Override
    public T get(Class<T> tipo,int id) {
        
        T obj=(T)sesion.get(tipo, id);
        return obj;
    
    }

    @Override
    public void add(T objeto) {
        sesion.beginTransaction();
         sesion.save(objeto);
       sesion.getTransaction().commit();
       
    }

    @Override
    public void delete(T objeto) {
        sesion.beginTransaction();
         sesion.delete(objeto);
       sesion.getTransaction().commit();}

    @Override
    public void update(T objeto) {
         sesion.beginTransaction();
         sesion.update(objeto);
       sesion.getTransaction().commit();}

    @Override
    public void conectar(){
        sesion=HibernateUtil.getSessionFactory().openSession();
    }
    @Override
    public void desconectar(){
        sesion.close();
    }

    @Override
    public List<T> find(String consulta, Map<String, Object> params) {
        
        Query cons=sesion.getNamedQuery(consulta);
        /*
        Iterator it= params.keySet().iterator();
        
        while (it.hasNext()) {
            String parametro = (String)it.next();
            cons.setParameter(parametro, params.get(parametro));
        }
        */
        for (String param : params.keySet()) {
            cons.setParameter(param, params.get(param));
        }
        List<T> lista=cons.list();
        
        return lista;
        
    
    }
    
}
