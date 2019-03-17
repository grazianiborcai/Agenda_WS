package br.com.gda.business.materialMovement.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class MatmovInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codMatmov;
	public long codStore;
	public long codMat;
	public char codMatmovType;
	public String codLanguage;
	public int quantity;
	public LocalDate postingDate;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	
	
	public MatmovInfo() {
		codOwner = DefaultValue.number();
		codMatmov = DefaultValue.number();
		codStore = DefaultValue.number();
		codMat = DefaultValue.number();
		codMatmovType = DefaultValue.character();
		codLanguage = DefaultValue.language();
		quantity = DefaultValue.number();
		lastChangedBy = DefaultValue.number();
	}
	
	
	
	public static MatmovInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatmovInfo.class);
	}
	
	
	
	public static List<MatmovInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatmovInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner		>>> 32));
		result = result * 31 + (int) (codMatmov	^ (codMatmov 	>>> 32));
		result = result * 31 + (int) (codStore	^ (codStore 	>>> 32));
		result = result * 31 + (int) (codMat 	^ (codMat 		>>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MatmovInfo))
			return false;
		
		
		MatmovInfo obj = (MatmovInfo) o;		
		return (codOwner  == obj.codOwner  && 
				codMatmov == obj.codMatmov && 
				codOwner  == obj.codOwner  && 
				codMat    == obj.codMat			);
	}
}
