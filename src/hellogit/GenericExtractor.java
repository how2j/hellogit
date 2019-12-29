package hellogit;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class GenericExtractor {
	public static Class<?> getClass(Type type,int i){
		if(type instanceof ParameterizedType){
			return getGenericClass((ParameterizedType) type,i);
		}else if(type instanceof TypeVariable){
			TypeVariable<?> typeVariable = (TypeVariable<?>) type;
			return getClass(typeVariable.getBounds()[0],0);
		}else{
			return (Class<?>) type;
		}
	}
	private static Class<?> getGenericClass(ParameterizedType parameterizedType,int i){
		Type genericClass = parameterizedType.getActualTypeArguments()[i];
		if(genericClass instanceof ParameterizedType){
			return (Class<?>) ((ParameterizedType) genericClass).getRawType();
		}else if (genericClass instanceof GenericArrayType){
			return (Class<?>) ((GenericArrayType) genericClass)
					.getGenericComponentType();
		}else if(genericClass instanceof TypeVariable){
			TypeVariable<?> typeVariable = (TypeVariable<?>) genericClass;
			Type bound = typeVariable.getBounds()[0];
			return getClass(bound,0);
		}else{
			return (Class<?>)genericClass;
		}
	}
	private GenericExtractor(){
		super();
	}
}
