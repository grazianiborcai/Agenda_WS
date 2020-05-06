package br.com.mind5.business.refundPolicyOwner.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class RefupownInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String codRefundPolicy;
	public String txtRefundPolicy;
	public int hourBefore;
	
	
	public RefupownInfo() {
		super();
		
		codOwner = DefaultValue.number();
		hourBefore = DefaultValue.number();
	}
	
	
	
	public static RefupownInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, RefupownInfo.class);
	}
	
	
	
	public static List<RefupownInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, RefupownInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		
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
		
		
		if (!(o instanceof RefupownInfo))
			return false;
		
		
		RefupownInfo obj = (RefupownInfo) o;
		return (codOwner == obj.codOwner &&
				isStringEqual(codRefundPolicy, obj.codRefundPolicy));
	}
}
