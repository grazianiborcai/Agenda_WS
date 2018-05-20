package br.com.gda.business.masterData.info;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;

public final class MatCategInfo implements Cloneable {
	public int codCategory;
	public String txtCategory;
	public String codLanguage;
	
	
	public MatCategInfo() {
		this.codCategory = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
}
