package com.module.faces.geral;


import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Converter simples para ser usado nos selectOneMenu do jsf
 * 
 * Fonte: http://www.rponte.com.br/2008/07/26/entity-converters-pra-da-e-vender/
 * 
 * @author Levy Moreira
 *
 */
@FacesConverter(value="genConverter")
public class GenericConverter implements Converter {


    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {  
//        System.out.println("getAsObject = "+ value);
        if (value != null) {  
            return this.getAttributesFrom(component).get(value);  
        }  
        return null;  
    }  

    public String getAsString(FacesContext ctx, UIComponent component, Object value) {  
//         System.out.println("getAsString = "+ value);
        if (value != null && !"".equals(value) && !"null".equals(value)) {  
//            System.out.println("entrou");

            IGenericModel entity = (IGenericModel) value;  

            // adiciona item como atributo do componente  
            this.addAttribute(component, entity);  

            Integer codigo = entity.getId();  
            if (codigo != null) {  
                return String.valueOf(codigo);  
            }  
        }  

        return (String) value;  
    }  

    protected void addAttribute(UIComponent component, IGenericModel o) {  
//        System.out.println("addAttribute = "+o.getId() );
        String key = o.getId().toString(); // codigo como chave neste caso  
        this.getAttributesFrom(component).put(key, o);  
    }  

    protected Map<String, Object> getAttributesFrom(UIComponent component) {  
        return component.getAttributes();  
    }  

}