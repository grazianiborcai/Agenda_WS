package br.com.gda.business.material.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.helper.RecordMode;
import br.com.gda.info.RecordInfo;

public final class MatInfo extends RecordInfo implements Cloneable {
	public long codOwner;
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
	//TODO: testar material precisão com mais de 2 casas decimais
	
	
	public MatInfo() {
		this.codOwner = DefaultValue.number();		
		this.codMat = DefaultValue.number();
		this.codType = DefaultValue.number();
		this.codCategory = DefaultValue.number();
		this.price = DefaultValue.number();
		this.priceUnit = 1;
		this.codGroup = DefaultValue.number();		
		this.codBusiness = DefaultValue.number();	
		this.codLanguage = Language.getDefaultLanguage();
		this.isLocked = false;
		this.recordMode = RecordMode.RECORD_OK;	
	}
	
	
	
	public static MatInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatInfo.class);
	}
	
	
	
	public static List<MatInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner	>>> 32));
		result = result * 31 + (int) (codMat 	^ (codMat 	>>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MatInfo))
			return false;
		
		
		MatInfo obj = (MatInfo) o;		
		return (codOwner == obj.codOwner && codMat == obj.codMat);
	}
}
