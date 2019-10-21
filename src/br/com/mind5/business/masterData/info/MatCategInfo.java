package br.com.mind5.business.masterData.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class MatCategInfo extends InfoRecord implements Cloneable {
	public int codMatCateg;
	public String txtMatCateg;
	
	
	public MatCategInfo() {
		super(MatCategInfo.class);
		
		codMatCateg = DefaultValue.number();
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
		
		result = result * 31 + codMatCateg;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof MatCategInfo))
			return false;
		
		
		MatCategInfo obj = (MatCategInfo) o;		
		return (codMatCateg == obj.codMatCateg);
	}
}
