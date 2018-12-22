package br.com.gda.business.materialSnapshot.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.helper.RecordMode;
import br.com.gda.info.InfoRecord;

public final class MatSnapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codSnapshot;
	public long codMat;
	public String txtMat;
	public String description;
	public int codType;
	public String txtType;
	public int codCategory;
	public String txtCategory;
	public double price;
	public int priceUnit;
	public String codCurr;
	public String txtCurr;
	public String codUnit;
	public String txtUnit;
	public int codGroup;
	public String txtGroup; 
	public int codBusiness;
	public String txtBusiness; 
	public String codLanguage;
	public boolean isLocked;
	public String recordMode;
	public LocalDateTime lastChanged;
	
	
	public MatSnapInfo() {
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codMat = DefaultValue.number();
		codType = DefaultValue.number();
		codCategory = DefaultValue.number();
		price = DefaultValue.number();
		priceUnit = 1;
		codGroup = DefaultValue.number();		
		codBusiness = DefaultValue.number();	
		codLanguage = DefaultValue.language();
		isLocked = DefaultValue.boole();
		recordMode = RecordMode.RECORD_OK;	
	}
	
	
	
	public static MatSnapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatSnapInfo.class);
	}
	
	
	
	public static List<MatSnapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatSnapInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  	^ (codOwner		>>> 32));
		result = result * 31 + (int) (codSnapshot 	^ (codSnapshot 	>>> 32));
		result = result * 31 + (int) (codMat 		^ (codMat 		>>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MatSnapInfo))
			return false;
		
		
		MatSnapInfo obj = (MatSnapInfo) o;		
		return (codOwner 	== obj.codOwner 	&&
				codSnapshot == obj.codSnapshot 	&&
				codMat 		== obj.codMat		);
	}
}
