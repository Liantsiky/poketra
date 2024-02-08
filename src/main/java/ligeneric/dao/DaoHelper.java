/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ligeneric.dao;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import ligeneric.annotation.Column;
import ligeneric.annotation.Foreign;
import ligeneric.annotation.PkType;
import ligeneric.annotation.Primary;
import ligeneric.annotation.Table;

/**
 *
 * @author liantsiky
 */

public class DaoHelper {
	
	 public static final HashMap <Class <?>, Function<String,?>> PARSING = new HashMap<>();
	    static{
	        PARSING.put(int.class, Integer::parseInt);
	        PARSING.put(Integer.class,Integer::parseInt);
	        PARSING.put(double.class, Double :: parseDouble);
	        PARSING.put(boolean.class, Boolean::parseBoolean);
	        PARSING.put(String.class, Function.identity());
	        PARSING.put(LocalDate.class, LocalDate::parse);
	        PARSING.put(LocalDateTime.class, LocalDateTime::parse);
	        PARSING.put(LocalTime.class, LocalTime::parse);
	    }
	
	/**
	 * get the list of the fields we have to insert for one Entity
	 * @param entity
	 * @return
	 */
    public static  List<Field> getFieldsInsert(Object entity) {
    	List<Field> liste = new ArrayList<Field>();
    	for(Field field : entity.getClass().getDeclaredFields()) {
    		if(field.isAnnotationPresent(Primary.class)) {
    			if(field.getAnnotation(Primary.class).pktype() == PkType.AUTO) {
    				continue;
    			}
    		}
    		if(field.isAnnotationPresent(Column.class) || field.isAnnotationPresent(Foreign.class)) {
    			liste.add(field);
    		}
    	}
    		return liste;
     }
    
    
	/**
	 * Get the fields of a class with the corresponding name columns in the database
	 * @param Class<T> classe
	 * @return Map<Field,String> 
	 * @throws Exception
	 */
    public static <T> Map<Field,String> getFieldsColumns(Class<T> classe) throws Exception {
        Map <Field,String> fieldscolumns = new HashMap<>();
        Field[] fields = classe.getDeclaredFields();
        for (Field field : fields) {
//        	for(Annotation annotation : field.getDeclaredAnnotations()) {
//        		System.out.println(annotation);
//        	}
        	if (field.isAnnotationPresent(Foreign.class)) {
//        		System.out.println(field.getName());
        		fieldscolumns.put(field,field.getAnnotation(Foreign.class).join());
        	}
        	else if(field.isAnnotationPresent(Column.class)){
//        		System.out.println(field.getName());
                fieldscolumns.put(field,field.getAnnotation(Column.class).name());
            } 
        }
        return  fieldscolumns;
    }
    
    /**
     * get The setterMethod name of the associate field
     * @param field
     * @return
     */
    public static String getSetterName(Field field) {
    	String fieldName = field.getName();
    	return 	"set"+fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }
    
    /**
     * Get the method name of the setters
     * @param <T>
     * @param classe
     * @return
     * @throws java.lang.Exception
     */
    public static <T> Map<Field,String> getFieldsSettersName(Class <T> classe) throws Exception{
    	Map <Field,String> fieldsColumns = DaoHelper.getFieldsColumns(classe);
    	Map <Field,String> fieldsSetters = new HashMap<Field, String>();
    	for (Field field: fieldsColumns.keySet()) {
    		String fieldSetter = DaoHelper.getSetterName(field);
    		fieldsSetters.put(field, fieldSetter);
    	}
    	return fieldsSetters;
    }
    /**
     * Get the fields of a class with the corresponding setters 
     * @param Class <T> classe
     * @return Map<Field,Method>
     * @throws Exception
     */
    public static <T> Map<Field,Method> getFieldsSetters(Class <T> classe) throws Exception{
    	Map <Field,String> fieldsColumns = DaoHelper.getFieldsColumns(classe);
    	Map <Field,Method> fieldsSetters = new HashMap<Field, Method>();
    	Method [] methods = classe.getMethods();
    	for (Field field: fieldsColumns.keySet()) {
    		String fieldSetter = DaoHelper.getSetterName(field);
    		for(Method method : methods) {
    			if(method.getName().equals(fieldSetter) ) {
    				fieldsSetters.put(field, method);
    			}
    		}
    	}
    	return fieldsSetters;
    }
    
    /**
     * Get a long string of all the columns of the object
     * @param toConcat
     * @return
     * @throws Exception
     */
    public static String concate(List<Field> toConcat) {
    	int size = toConcat.size();		
    	int counter = 1;
    	String column = "(";
    	
    	for(Field field : toConcat) {
    		if(field.isAnnotationPresent(Column.class)) {    			
    			column = column + field.getAnnotation(Column.class).name();
    		} else if(field.isAnnotationPresent(Foreign.class)) {
    			column = column + field.getAnnotation(Foreign.class).join();
    		}
    		
    		if(counter == size) {
    			column = column + ")";
    		} else {
    			column = column + ",";
    		}
    		counter++;
    	}
    	return column;
    }
    
    /**
     * get the String request of a select All with the tableName
     * @param <T>
     * @param classe
     * @return
     */
    public static <T> String getSelectAllRequest(Class<T> classe)  {
    	return "select * from " + classe.getAnnotation(Table.class).name();
    }
    
    /**
     * get the String request of a select All with a view or a function
     * @param <T>
     * @param classe
     * @return
     */
    public static <T> String getSelectAllRequestView(Class<T> classe,String view)  {
    	return "select * from " + view;
    }
    
    /**
     * get the String request of a select with a predicat 
     * @param <T>
     * @param classe
     * @return
     */
    public static <T> String getSelectPredicatRequest(Class <T> classe,String predicat) {
    	return DaoHelper.getSelectAllRequest(classe) + " where " + predicat;
    }
    

    /**
     * get the String request of a select from a view or function with a predicat 
     * @param <T>
     * @param classe
     * @return
     */
    public static <T> String getSelectPredicatRequestView(Class <T> classe,String view,String predicat) {
    	return DaoHelper.getSelectAllRequestView(classe,view) + " where " + predicat;
    }
    
    /**
     * get the String request of a select by id
     * @param <T>
     * @param <K>
     * @param classe
     * @param id
     * @return String
     * @throws Exception
     */
    public static <T,K> String getSelectByIdRequest(Class<T> classe, K id) throws Exception {
    	Field pk = findPrimary(classe);
    	return "select * from " + classe.getAnnotation(Table.class).name() + " where " + pk.getAnnotation(Column.class).name() + "='" + id +"'";                     
    }
    
    /**
     * Find the primary key Field of one class
     * @param <T>
     * @param myClass
     * @return Field
     * @throws Exception
     */
    public static <T> Field findPrimary(Class<T> myClass) throws Exception {
    	Field result  = null;
    	for(Field field : myClass.getDeclaredFields()) {
    		if(field.isAnnotationPresent(Primary.class)) {
    			result = field;
    		}
    	}
    	return result;
    }
    /**
     * get the value of the primary key of the foreign Field 
     * @param foreignField
     * @return
     * @throws Exception
     */
    public static String getForeignId(Field foreignField,Object o) throws Exception {
    	String result = "";
    	//find the primary field of the many to one field
		Field field = findPrimary(foreignField.getType());
		
		//invoke the method processus
		String fieldName = field.getName();
		String getMethod = "get"+fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
		Method method = foreignField.getType().getDeclaredMethod(getMethod);
		
		//rendre l'objet many to one accessible
		foreignField.setAccessible(true);
		//instancer l'objet many to one
		Object foreignObject = foreignField.get(o);
		//invoke la method 
		result = String.valueOf(method.invoke(foreignObject));
		
    	return result;
    }
    
    /**
     * get the associate getter method of a field
     * @param field
     * @return
     * @throws Exception
     */
    public static <T> Method getGetterMethod(Class <T> myClass,Field field) throws Exception {
    	Method result = null;
    	
    	String getterName = "get"+field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
    	result = myClass.getDeclaredMethod(getterName);
    	return result;
    }
    /**
     * Get the String of an insert request
     * @param toInsert
     * @return
     */
	public static String getInsertRequest(Object toInsert) throws Exception {
		String table = toInsert.getClass().getAnnotation(Table.class).name();
		List <Field> fields = getFieldsInsert(toInsert);
		String columns = concate(getFieldsInsert(toInsert));
		int size = fields.size()	;
		int counter = 1;
		
		String request = "insert into "+ table + " "+ columns + "values (";
		for(Field field : fields) {
			String value = "";
			
			//check if it's a foreign key or not
			if(field.isAnnotationPresent(Foreign.class)) {
				//prendre les fields de cette objet
				value = getForeignId(field,toInsert);
			} else {
				value = String.valueOf(getGetterMethod(toInsert.getClass(),field).invoke(toInsert));
			}
			
			//check if the type of the field is a date or not
			if (field.getType() == Date.class) {
				request = request + "TO_DATE ('"+ value +"','YYYY-MM-DD')";
			}  else { 
				request = request + "'"+ value +"'";
			}
			
			//check if the chain is over and close the brackets
			if(counter == size) {
				request = request + ")";
			} else {
				request = request + ",";
			}
			counter++;
//			System.out.println(request);
		}
		return request;
	}
	
	/**
	 * set the object that we are gonna list
	 * @param <T>
	 * @param classe
	 * @param resultset
	 * @return
	 * @throws Exception
	 */
	public static <T> T setObject (Class<T> classe,ResultSet resultset,Connection connexion) throws Exception {
		T result = classe.getDeclaredConstructor().newInstance();
		Map <Field,String> fieldsColumns = DaoHelper.getFieldsColumns(classe);
		Map <Field,Method> fieldsSetters = DaoHelper.getFieldsSetters(classe);
		
		for(Field field : fieldsColumns.keySet()) {
			if(field.isAnnotationPresent(Foreign.class)) {
				//get the type of the field 
				Class<?> fieldType =  field.getType();
				
				// Instanciate an object of type of this field
                Object fk = fieldType.getDeclaredConstructor().newInstance();
                // Get the column name of the joined column
                String columnName = field.getAnnotation(Foreign.class).join();
                
                // Get the primary key  (id) of the field of the object
                Field pkField = findPrimary(fieldType);
                
                // get the setId of the field (setter of the primary key of the field)
                String setterName = "set"+pkField.getName().substring(0, 1).toUpperCase() + pkField.getName().substring(1);
                Method setter = fk.getClass().getDeclaredMethod(setterName, pkField.getType());
                
                // get the field value (FK values) from the databases 
                Class<?> fieldPkTypeClass = pkField.getType();
                String fieldPkType = pkField.getType().getName();
                
//                System.out.println(pkField.getGenericType());
                // Invoke the primary key setter of the field
//                setter.invoke(fk, resultset.getObject(columnName, fieldPkTypeClass));
                String value = resultset.getString(columnName);
                // System.out.println(value);

				
                Function< String, ?> parser = PARSING.get(pkField.getType());
                Object foreignValue = parser.apply(value);
                setter.invoke(fk, foreignValue);
                
                // Getter of the primary key of the field
                String getterName = "get"+pkField.getName().substring(0, 1).toUpperCase() + pkField.getName().substring(1);
                Method getter = fk.getClass().getDeclaredMethod(getterName);
                //find by id the object and set it
                fk = DAO.findById(fieldType,getter.invoke(fk), connexion);
                
                fieldsSetters.get(field).invoke(result,fk);
			} else if(field.isAnnotationPresent(Column.class)){				
				String value = resultset.getString(fieldsColumns.get(field));
//				System.out.println(field.getGenericType());
//				System.out.println(PARSING.get(field.getGenericType()));
				Function <String,?> parser = PARSING.get(field.getGenericType());
				Object fieldValue = parser.apply(value);
				fieldsSetters.get(field).invoke(result,fieldValue);
			}
		}			
		return result;
	}
	
	
	
	
}
