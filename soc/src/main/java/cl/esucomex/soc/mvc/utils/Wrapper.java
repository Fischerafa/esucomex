/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.esucomex.soc.mvc.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author richa
 */
public class Wrapper {
    public static Map<String, Object> ok(List lista, Long total) {
        HashMap<String, Object> respuesta =  new HashMap<>();
        respuesta.put("data", lista);
        respuesta.put("success", true);
        respuesta.put("total", total);
        respuesta.put("message", "Ok");
        return respuesta;
    }
    
    public static Map<String,Object> error(String mensaje) {
        HashMap<String, Object> respuesta =  new HashMap<>();
        respuesta.put("data", null);
        respuesta.put("success", false);
        respuesta.put("total", 0L);
        respuesta.put("message", mensaje);
        return respuesta;
    }
}
