package br.com.mind5.business.materialMovementSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MatmarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codMatmov;
	public long codStore;
	public long codMat;	
	public int postingYearMonth;
	public int postingYear;
	public String username;
	
	
	public MatmarchInfo() {
		super(MatmarchInfo.class);
		
		codOwner = DefaultValue.number();
		codMatmov = DefaultValue.number();
		codStore = DefaultValue.number();
		codMat = DefaultValue.number();		
		postingYearMonth = DefaultValue.number();
		postingYear = DefaultValue.number();
	}
	
	
	
	public static MatmarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatmarchInfo.class);
	}
	
	
	
	public static List<MatmarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatmarchInfo.class);
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
		
		
		if (!(o instanceof MatmarchInfo))
			return false;
		
		
		MatmarchInfo obj = (MatmarchInfo) o;		
		return (codOwner  == obj.codOwner  && 
				codMatmov == obj.codMatmov && 
				codOwner  == obj.codOwner  && 
				codMat    == obj.codMat			);
	}
}
