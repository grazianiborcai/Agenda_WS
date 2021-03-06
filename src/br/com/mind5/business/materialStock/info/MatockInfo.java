package br.com.mind5.business.materialStock.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MatockInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codMat;
	public char codMatmovType;
	public int quantityToUpdate;
	public int quantityStock;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public MatockInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codMat = DefaultValue.number();
		codMatmovType = DefaultValue.character();
		quantityStock = 0;
		quantityToUpdate = 0;
	}
	
	
	
	public static MatockInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatockInfo.class);
	}
	
	
	
	public static List<MatockInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatockInfo.class);
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
		
		
		if (!(o instanceof MatockInfo))
			return false;
		
		
		MatockInfo obj = (MatockInfo) o;		
		return (codOwner  == obj.codOwner  && 
				codOwner  == obj.codOwner  && 
				codMat    == obj.codMat			);
	}
}
