package br.com.mind5.masterData.refundPolicy.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class RefupoInfo extends InfoRecord implements Cloneable {
	public String codRefundPolicy;
	public String txtRefundPolicy;
	public int hourBefore;
	
	
	public RefupoInfo() {
		super();
		
		hourBefore = DefaultValue.number();
	}
	
	
	
	public static RefupoInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, RefupoInfo.class);
	}
	
	
	
	public static List<RefupoInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, RefupoInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (codRefundPolicy != null) {
			char[] chars = codRefundPolicy.toCharArray();
			
			for (char eachChar : chars) {
				result = result * 31 + (int) eachChar;
			}
		}		
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof RefupoInfo))
			return false;
		
		
		RefupoInfo obj = (RefupoInfo) o;
		return isStringEqual(codRefundPolicy, obj.codRefundPolicy);
	}
}
