package br.com.gda.business.materialEmployee.info;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.store.info.StoreEmpInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.helper.RecordMode;

public final class MatEmpInfo implements Cloneable {
	public long codOwner;
	public long codStore;		
	public long codEmployee;
	public long codMat;
	public String codLanguage;
	public String recordMode;
	
	
	
	public MatEmpInfo() {
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();		
		codEmployee = DefaultValue.number();
		codMat = DefaultValue.number();
		codLanguage = Language.getDefaultLanguage();
		recordMode = RecordMode.RECORD_OK;
	}
	
	
	
	public OwnerInfo toOwnerInfo() {
		OwnerInfo owner = new OwnerInfo();
		owner.codOwner = codOwner;
		owner.codLanguage = codLanguage;
		return owner;
	}
	
	
	
	public StoreInfo toStoreInfo() {
		StoreInfo emp = new StoreInfo();
		emp.codOwner = codOwner;
		emp.codStore = codStore;
		emp.codLanguage = codLanguage;
		return emp;
	}
	
	
	
	public EmpInfo toEmpInfo() {
		EmpInfo emp = new EmpInfo();
		emp.codOwner = codOwner;
		emp.codEmployee = codEmployee;
		emp.codLanguage = codLanguage;
		return emp;
	}
	
	
	
	public MatInfo toMatInfo() {
		MatInfo mat = new MatInfo();
		mat.codOwner = codOwner;
		mat.codMat = codMat;
		mat.codLanguage = codLanguage;
		return mat;
	}
	
	
	
	public StoreEmpInfo toStoreEmpInfo() {
		StoreEmpInfo storeEmp = new StoreEmpInfo();
		storeEmp.codOwner = codOwner;
		storeEmp.codStore = codStore;
		storeEmp.codEmployee = codEmployee;
		storeEmp.codLanguage = codLanguage;
		return storeEmp;
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
