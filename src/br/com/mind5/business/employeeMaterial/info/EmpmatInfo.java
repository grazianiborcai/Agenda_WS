package br.com.mind5.business.employeeMaterial.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class EmpmatInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codEmployee;
	public String nameEmployee;
	public long codMat;
	public String txtMat;
	public int codType;
	public String txtType;
	public int codCategory;
	public String txtCategory;
	public int priceUnit;
	public String codUnit;
	public String txtUnit;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	
	
	public EmpmatInfo() {
		super(EmpmatInfo.class);
		
		codOwner = DefaultValue.number();	
		codEmployee = DefaultValue.number();
		codMat = DefaultValue.number();
		codMat = DefaultValue.number();
		codType = DefaultValue.number();
		codCategory = DefaultValue.number();
		priceUnit = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		lastChangedBy = DefaultValue.number();
	}
	
	
	
	public static EmpmatInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmpmatInfo.class);
	}
	
	
	
	public static List<EmpmatInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmpmatInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		result = result * 31 + (int) (codMat 	  ^ (codMat 	 >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof EmpmatInfo))
			return false;
		
		
		EmpmatInfo obj = (EmpmatInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codEmployee == obj.codEmployee 	&&
				codMat 		== obj.codMat);
	}
}
