package br.com.gda.business.materialStore.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.helper.RecordMode;
import br.com.gda.info.InfoRecord;

public final class MatStoreInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public long codMat;
	public String txtMat;
	public int codType;
	public String txtType;
	public int codCategory;
	public String txtCategory;
	public int priceUnit;
	public String codUnit;
	public String txtUnit;
	public String codLanguage;
	public String recordMode;
	
	
	
	public MatStoreInfo() {
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();	
		codMat = DefaultValue.number();
		codType = DefaultValue.number();
		codCategory = DefaultValue.number();
		priceUnit = DefaultValue.number();
		codLanguage = Language.getDefaultLanguage();
		recordMode = RecordMode.RECORD_OK;
	}
	
	
	
	public static MatStoreInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatStoreInfo.class);
	}
	
	
	
	public static List<MatStoreInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatStoreInfo.class);
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
		
		
		if (!(o instanceof MatStoreInfo))
			return false;
		
		
		MatStoreInfo obj = (MatStoreInfo) o;		
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore &&
				codMat   == obj.codMat);
	}
}
