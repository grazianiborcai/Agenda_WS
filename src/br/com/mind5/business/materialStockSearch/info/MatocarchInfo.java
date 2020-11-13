package br.com.mind5.business.materialStockSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MatocarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codMat;
	public String username;
	
	
	public MatocarchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codMat = DefaultValue.number();
	}
	
	
	
	public static MatocarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatocarchInfo.class);
	}
	
	
	
	public static List<MatocarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatocarchInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner		>>> 32));
		result = result * 31 + (int) (codStore	^ (codStore 	>>> 32));
		result = result * 31 + (int) (codMat 	^ (codMat 		>>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MatocarchInfo))
			return false;
		
		
		MatocarchInfo obj = (MatocarchInfo) o;		
		return (codOwner  == obj.codOwner  && 
				codOwner  == obj.codOwner  && 
				codMat    == obj.codMat			);
	}
}
