package br.com.mind5.business.masterData.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class EntityCategInfo extends InfoRecord implements Cloneable {
	public String codEntityCateg;
	public String txtEntityCateg;
	
	
	public EntityCategInfo() {
		super(EntityCategInfo.class);
	}
	
	
	
	public static EntityCategInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EntityCategInfo.class);
	}
	
	
	
	public static List<EntityCategInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EntityCategInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (codEntityCateg != null)
			result = result * 31 + (int) codEntityCateg.hashCode();
		
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof EntityCategInfo))
			return false;
		
		
		EntityCategInfo obj = (EntityCategInfo) o;	
		return super.isStringEqual(codEntityCateg, obj.codEntityCateg);
	}
}
