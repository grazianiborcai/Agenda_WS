package br.com.mind5.business.masterData.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CartCategInfo extends InfoRecord implements Cloneable {
	public char codItemCateg;
	public String txtItemCateg;
	
	
	public CartCategInfo() {
		super(CartCategInfo.class);
		
		codItemCateg = DefaultValue.character();
	}
	
	
	
	public static CartCategInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CartCategInfo.class);
	}
	
	
	
	public static List<CartCategInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CartCategInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		result = result * 31 + (int) codItemCateg;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CartCategInfo))
			return false;
		
		
		CartCategInfo obj = (CartCategInfo) o;		
		return codItemCateg == obj.codItemCateg;
	}
}
