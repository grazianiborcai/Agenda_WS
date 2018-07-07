package br.com.gda.business.materialStore.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.helper.RecordMode;
import br.com.gda.info.RecordInfo;

public final class MatStoreInfo extends RecordInfo implements Cloneable {
	public long codOwner;
	public long codStore;	
	public long codMat;
	public String codLanguage;
	public String recordMode;
	
	
	
	public MatStoreInfo() {
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();	
		codMat = DefaultValue.number();
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
}
