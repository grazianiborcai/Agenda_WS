package br.com.mind5.business.materialStoreSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MatorarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public long codMat;
	public String username;
	public String recordMode;
	
	
	public MatorarchInfo() {
		super(MatorarchInfo.class);
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();	
		codMat = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static MatorarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatorarchInfo.class);
	}
	
	
	
	public static List<MatorarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatorarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner  >>> 32));
		result = result * 31 + (int) (codStore 	^ (codStore	 >>> 32));
		result = result * 31 + (int) (codMat 	^ (codMat	 >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MatorarchInfo))
			return false;
		
		
		MatorarchInfo obj = (MatorarchInfo) o;		
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore &&
				codMat   == obj.codMat);
	}
}
