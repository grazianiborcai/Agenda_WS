package br.com.gda.business.materialStore.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class MatoreInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public long codMat;
	public String txtMat;
	public int codType;
	public String txtType;
	public int codMatCateg;
	public String txtMatCateg;
	public long matPrice;
	public long matPrice1;
	public long matPrice2;
	public long matPrice3;
	public long matPrice4;
	public long matPrice5;
	public long matPrice6;
	public long matPrice7;
	public int quantityStock;
	public int priceUnit;
	public String codUnit;
	public String txtUnit;
	public String codLanguage;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	public String recordMode;
	
	
	
	public MatoreInfo() {
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();	
		codMat = DefaultValue.number();
		codType = DefaultValue.number();
		codMatCateg = DefaultValue.number();
		priceUnit = DefaultValue.number();
		matPrice = DefaultValue.number();
		matPrice1 = DefaultValue.number();
		matPrice2 = DefaultValue.number();
		matPrice3 = DefaultValue.number();
		matPrice4 = DefaultValue.number();
		matPrice5 = DefaultValue.number();
		matPrice6 = DefaultValue.number();
		matPrice7 = DefaultValue.number();
		quantityStock = DefaultValue.number();
		codLanguage = DefaultValue.language();
		lastChangedBy = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static MatoreInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatoreInfo.class);
	}
	
	
	
	public static List<MatoreInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatoreInfo.class);
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
		
		
		if (!(o instanceof MatoreInfo))
			return false;
		
		
		MatoreInfo obj = (MatoreInfo) o;		
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore &&
				codMat   == obj.codMat);
	}
}
