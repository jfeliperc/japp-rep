package com.module.faces.geral;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EmbeddedId;
import javax.persistence.Id;

@FacesConverter(value="genConverter")
public class GenericConverter implements Converter {

	public Object getAsObject(FacesContext ctx, UIComponent component,
			String value) {
		if (value != null) {
			return component.getAttributes().get(value);
		}
		return null;
	}

	public String getAsString(FacesContext ctx, UIComponent component,
			Object obj) {
		if (obj != null && !"".equals(obj)) {
			String id;
			try {
				id = this.getId(getClazz(ctx, component), obj);
				if (id == null) {
					id = "";
				}
				id = id.trim();
				component.getAttributes().put(id,
						getClazz(ctx, component).cast(obj));
				return id;
			} catch (SecurityException e) {
				e.printStackTrace(); // seu log aqui
			} catch (IllegalArgumentException e) {
				e.printStackTrace(); // seu log aqui
			} catch (NoSuchFieldException e) {
				e.printStackTrace(); // seu log aqui
			} catch (IllegalAccessException e) {
				e.printStackTrace(); // seu log aqui
			}
		}
		return null;
	}

	/**
	 * Obtém, via expression language, a classe do objeto.
	 *
	 * @param FacesContext facesContext
	 * 
	 * @param UICompoment compoment
	 *     
	 * @return  Class<?>
	 */
	private Class<?> getClazz(FacesContext facesContext, UIComponent component) {
		return component.getValueExpression("value").getType(
				facesContext.getELContext());
	}


	/**
	 * Retorna a representação em String do retorno do método anotado com @Id ou @EmbeddedId do objeto.
	 *
	 * @param Class<?> clazz
	 *            
	 * @return  String
	 */
	public String getId(Class<?> clazz, Object obj) throws SecurityException,
			NoSuchFieldException, IllegalArgumentException,
			IllegalAccessException {

		List<Class<?>> hierarquiaDeClasses = this.getHierarquiaDeClasses(clazz);
		
		for (Class<?> classeDaHierarquia : hierarquiaDeClasses) {
			for (Field field : classeDaHierarquia.getDeclaredFields()) {
				if ((field.getAnnotation(Id.class)) != null
						|| field.getAnnotation(EmbeddedId.class) != null) {
					Field privateField = classeDaHierarquia
							.getDeclaredField(field.getName());
					privateField.setAccessible(true);
					if (privateField.get(clazz.cast(obj)) != null) {

						return (String) field.getType()
								.cast(privateField.get(clazz.cast(obj)))
								.toString();
					}
				}
			}
		}
		return null;
	}

	/**
	 * Retorna uma lista com a hierarquia de classes, sem considerar a classe Object.class
	 *
	 * @param Class<?> clazz
	 *            
	 * @return  List<Class<?>> clazz
	 */
	public List<Class<?>> getHierarquiaDeClasses(Class<?> clazz) {

		List<Class<?>> hierarquiaDeClasses = new ArrayList<Class<?>>();
		Class<?> classeNaHierarquia = clazz;
		while(classeNaHierarquia != Object.class) {
			hierarquiaDeClasses.add(classeNaHierarquia);
			classeNaHierarquia = classeNaHierarquia.getSuperclass();
			
		}
		return hierarquiaDeClasses;
	} 
}

	

//    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {  
////        System.out.println("getAsObject = "+ value);
//        if (value != null) {  
//            return this.getAttributesFrom(component).get(value);  
//        }  
//        return null;  
//    }  
//
//    public String getAsString(FacesContext ctx, UIComponent component, Object value) {  
////         System.out.println("getAsString = "+ value);
//        if (value != null && !"".equals(value) && !"null".equals(value)) {  
//
//            IGenericModel entity = (IGenericModel) value; 
//
//            this.addAttribute(component, entity);  
//
//            Integer codigo = entity.getId();  
//            if (codigo != null) {  
//                return String.valueOf(codigo);  
//            }  
//        }  
//
//        return (String) value;  
//    }  
//
//    protected void addAttribute(UIComponent component, IGenericModel o) {  
//        String key = o.getId().toString(); // codigo como chave neste caso
//        this.getAttributesFrom(component).put(key, o);  
//    }  
//
//    protected Map<String, Object> getAttributesFrom(UIComponent component) {  
//        return component.getAttributes();  
//    }  
//
//}