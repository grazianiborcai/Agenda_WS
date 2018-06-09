package br.com.gda.business.storeEmployee.info;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.masterData.info.EmpPosInfo;
import br.com.gda.business.store.info.StoreInfo;
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
	
	
	
	public EmpPosInfo toEmpPosInfo() {
		EmpPosInfo empPosInfo = new EmpPosInfo();
		
		empPosInfo.codPosition = codPositionStore;
		empPosInfo.txtPosition = txtPositionStore;
		empPosInfo.codLanguage = codLanguage;
		
		return empPosInfo;
	}
	
	
	
	public StoreInfo toStoreInfo() {
		StoreInfo storeInfo = new StoreInfo();
		
		storeInfo.codOwner = codOwner;
		storeInfo.codStore = codStore;
		storeInfo.codLanguage = codLanguage;
		
		return storeInfo;
	}
	
	
	
	public EmpInfo toEmpInfo() {
		EmpInfo empInfo = new EmpInfo();
		
		empInfo.codOwner = codOwner;
		empInfo.codEmployee = codEmployee;
		empInfo.codLanguage = codLanguage;
		
		return empInfo;
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
