package br.com.gda.business.materialEmployee.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.helper.RecordMode;
import br.com.gda.info.RecordInfo;

public final class MatEmpInfo extends RecordInfo implements Cloneable {
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
	
	
	
	public static MatEmpInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatEmpInfo.class);
	}
	
	
	
	public static List<MatEmpInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatEmpInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
