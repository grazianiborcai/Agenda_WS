package br.com.mind5.business.materialGroupStore.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MatoporeInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public int codGroup;
	public String txtGroup;
	public String username;
	
	
	public MatoporeInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();	
		codGroup = DefaultValue.number();
	}
	
	
	
	public static MatoporeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatoporeInfo.class);
	}
	
	
	
	public static List<MatoporeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatoporeInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner  >>> 32));
		result = result * 31 + (int) (codStore 	^ (codStore	 >>> 32));
		result = result * 31 + (int) (codGroup 	^ (codGroup	 >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MatoporeInfo))
			return false;
		
		
		MatoporeInfo obj = (MatoporeInfo) o;		
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore &&
				codGroup == obj.codGroup	);
	}
}
