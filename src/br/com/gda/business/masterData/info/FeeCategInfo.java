package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class FeeCategInfo extends InfoRecord implements Cloneable {
	public char codFeeCateg;
	public String txtFeeCateg;
	
	
	public FeeCategInfo() {
		super(FeeCategInfo.class);
		
		codFeeCateg = DefaultValue.character();
	}
	
	
	
	public static FeeCategInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FeeCategInfo.class);
	}
	
	
	
	public static List<FeeCategInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FeeCategInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		result = result * 31 + (int) codFeeCateg;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof FeeCategInfo))
			return false;
		
		
		FeeCategInfo obj = (FeeCategInfo) o;		
		return codFeeCateg == obj.codFeeCateg;
	}
}
