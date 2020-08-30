package br.com.mind5.business.materialList.info;

import java.util.List;

import br.com.mind5.common.CloneUtil;
import br.com.mind5.common.DefaultValue;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoRecord;



public final class MatlisInfo extends InfoRecord implements Cloneable {
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
	public int codSubgroup;
	public String txtSubgroup;
	public int sortSubgroup;
	public int codBusiness;
	public String txtBusiness; 
	public boolean isLocked;
	public List<FimistInfo> fimistes;
	public String recordMode;
	public String username;
	
	
	public MatlisInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		codMat = DefaultValue.number();
		codType = DefaultValue.number();
		codMatCateg = DefaultValue.number();
		priceUnit = 1;
		codGroup = DefaultValue.number();
		codSubgroup = DefaultValue.number();
		sortSubgroup = DefaultValue.number();
		codBusiness = DefaultValue.number();
		isLocked = DefaultValue.boole();
		fimistes = DefaultValue.list();
		recordMode = DefaultValue.recordMode();	
	}
	
	
	
	public static MatlisInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatlisInfo.class);
	}
	
	
	
	public static List<MatlisInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatlisInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		MatlisInfo deepCopy = (MatlisInfo) super.clone();
		
		deepCopy.fimistes = CloneUtil.cloneRecords(deepCopy.fimistes, this.getClass());
		
		return deepCopy;
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
		
		
		if (!(o instanceof MatlisInfo))
			return false;
		
		
		MatlisInfo obj = (MatlisInfo) o;		
		return (codOwner == obj.codOwner && 
				codMat   == obj.codMat);
	}
}
