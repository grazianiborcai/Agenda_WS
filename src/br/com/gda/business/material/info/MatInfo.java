package br.com.gda.business.material.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class MatInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codSnapshot;
	public long codMat;
	public String txtMat;
	public String description;
	public int codType;
	public String txtType;
	public int codMatCateg;
	public String txtMatCateg;
	public int priceUnit;
	public String codUnit;
	public String txtUnit;
	public int codGroup;
	public String txtGroup; 
	public int codBusiness;
	public String txtBusiness; 
	public boolean isLocked;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	
	//TODO: testar material precisao com mais de 2 casas decimais
	
	
	public MatInfo() {
		super(MatInfo.class);
		
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codMat = DefaultValue.number();
		codType = DefaultValue.number();
		codMatCateg = DefaultValue.number();
		priceUnit = 1;
		codGroup = DefaultValue.number();		
		codBusiness = DefaultValue.number();
		isLocked = DefaultValue.boole();
		recordMode = DefaultValue.recordMode();	
		lastChangedBy = DefaultValue.number();
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
