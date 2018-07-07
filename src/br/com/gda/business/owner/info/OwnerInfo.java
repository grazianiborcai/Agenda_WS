package br.com.gda.business.owner.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.helper.RecordMode;
import br.com.gda.info.RecordInfo;

public final class OwnerInfo extends RecordInfo implements Cloneable {
	public long codOwner;
	public String name;
	public String codLanguage;
	public String recordMode;
	
	
	public OwnerInfo() {
		this.codOwner = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
		this.recordMode = RecordMode.RECORD_OK;	
	}
	
	
	
	public static OwnerInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, OwnerInfo.class);
	}
	
	
	
	public static List<OwnerInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, OwnerInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
