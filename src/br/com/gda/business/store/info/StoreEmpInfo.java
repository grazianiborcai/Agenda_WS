package br.com.gda.business.store.info;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.helper.RecordMode;

public final class StoreEmpInfo implements Cloneable {
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
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
