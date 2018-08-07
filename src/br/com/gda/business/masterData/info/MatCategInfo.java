package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.info.RecordInfo;

public final class MatCategInfo extends RecordInfo implements Cloneable {
	public int codCategory;
	public String txtCategory;
	public String codLanguage;
	
	
	public MatCategInfo() {
		this.codCategory = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	public static MatCategInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, MatCategInfo.class);
	}
	
	
	
	public static List<MatCategInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, MatCategInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + codCategory;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MatCategInfo))
			return false;
		
		
		MatCategInfo obj = (MatCategInfo) o;		
		return (codCategory == obj.codCategory);
	}
}
