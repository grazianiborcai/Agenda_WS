package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class UserCategInfo extends InfoRecord implements Cloneable {
	public char codUserCategory;
	public String txtUserCategory;
	public String codLanguage;
	
	
	public UserCategInfo() {
		super(UserCategInfo.class);
		
		codUserCategory = DefaultValue.character();
		codLanguage = DefaultValue.language();
	}
	
	
	
	public static UserCategInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, UserCategInfo.class);
	}
	
	
	
	public static List<UserCategInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, UserCategInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) codUserCategory;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof UserCategInfo))
			return false;
		
		
		UserCategInfo obj = (UserCategInfo) o;		
		return (codUserCategory == obj.codUserCategory);
	}
}
