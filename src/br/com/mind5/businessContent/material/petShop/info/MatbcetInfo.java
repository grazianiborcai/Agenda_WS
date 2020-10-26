package br.com.mind5.businessContent.material.petShop.info;

import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MatbcetInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public int codType;
	public int codMatCateg;
	public int priceUnit;
	public String codUnit;
	public int codGroup;
	public int codSubgroup;
	public int codBusiness;
	public List<MatextInfo> matextes;
	public String recordMode;
	public String username;
	
	
	public MatbcetInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codType = DefaultValue.number();
		codMatCateg = DefaultValue.number();
		priceUnit = 1;
		codGroup = DefaultValue.number();		
		codSubgroup = DefaultValue.number();
		codBusiness = DefaultValue.number();
		recordMode = DefaultValue.recordMode();	
		matextes = DefaultValue.list();
	}
	
	
	
	public static MatbcetInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatbcetInfo.class);
	}
	
	
	
	public static List<MatbcetInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatbcetInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		MatbcetInfo deepCopy = (MatbcetInfo) super.clone();
		
		deepCopy.matextes = CloneUtil.cloneRecords(deepCopy.matextes, this.getClass());
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner  ^ (codOwner	>>> 32));
		result = result * 31 + (int) (codStore 	^ (codStore >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MatbcetInfo))
			return false;
		
		
		MatbcetInfo obj = (MatbcetInfo) o;		
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore);
	}
}
