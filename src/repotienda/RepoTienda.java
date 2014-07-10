/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repotienda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelo.TiendaCategoria;
import modelo.TiendaProducto;
import repositorio.IRepositorio;
import repositorio.Repositorio;

/**
 *
 * @author luis
 */
public class RepoTienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    
        IRepositorio<TiendaProducto> rp=new Repositorio<>();
        
        Map<String,Object> param=new HashMap<>();
        param.put("nombre", "Producto10");
        List<TiendaProducto> lp=rp.find("findByNombre", param);
        
        System.out.println("============Productos por nombre===========");
        for (TiendaProducto tiendaProducto : lp) {
            System.out.println("Nombre:"+tiendaProducto.getNombre());
        }
    
        Map<String,Object> param2=new HashMap<>();
        param2.put("precio", 500.0);
        List<TiendaProducto> lp2=rp.find("findByPrecio", param2);
        
        System.out.println("============Productos por precio===========");
        for (TiendaProducto tiendaProducto : lp2) {
            System.out.println("Nombre:"+tiendaProducto.getNombre());
        }
    
       
        List<TiendaProducto> lp3=rp.find("findByExistencias", 
                new HashMap<String,Object>());
        
    System.out.println("============Productos por existencias===========");
        for (TiendaProducto tiendaProducto : lp3) {
            System.out.println("Nombre:"+tiendaProducto.getNombre());
        }
        
        IRepositorio<TiendaCategoria> rc=new Repositorio<>();
        
        TiendaCategoria tc=rc.get(TiendaCategoria.class, 10);
        
        System.out.println("=======Productos por categoria=======");
        for (Object object : tc.getTiendaProductos()) {
            
            TiendaProducto tp=(TiendaProducto)object;
            System.out.println(tp.getNombre());
            
        }
    
        
    }
    
}
