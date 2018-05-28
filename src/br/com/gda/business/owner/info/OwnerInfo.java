package br.com.gda.business.owner.info;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.helper.RecordMode;

public final class OwnerInfo implements Cloneable {
	public long codOwner;
	public String name;
	public String codLanguage;
	public String recordMode;
	
	
	public OwnerInfo() {
		this.codOwner = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
		this.recordMode = RecordMode.RECORD_OK;	
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
