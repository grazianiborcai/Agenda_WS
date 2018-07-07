package br.com.gda.business.storeEmployee.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.helper.RecordMode;
import br.com.gda.info.RecordInfo;

public final class StoreEmpInfo extends RecordInfo implements Cloneable {
	public long codOwner;
	public long codStore;	
	public String nameStore;	
	public long codEmployee;
	public String nameEmployee;
	public long codPositionStore;
	public String txtPositionStore;
	public String codLanguage;
	public String recordMode;
	
	
	public StoreEmpInfo() {
		this.codOwner = DefaultValue.number();
		this.codStore = DefaultValue.number();
		this.codEmployee = DefaultValue.number();
		this.codPositionStore = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
		this.recordMode = RecordMode.RECORD_OK;		
	}
	
	
	
	public static StoreEmpInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StoreEmpInfo.class);
	}
	
	
	
	public static List<StoreEmpInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StoreEmpInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
