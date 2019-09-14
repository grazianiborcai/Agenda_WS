package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class AreaPhoneInfo extends InfoRecord implements Cloneable {
	public int codCountryPhone;
	public String codArea;
	public String txtArea;
	
	
	public AreaPhoneInfo() {
		super(AreaPhoneInfo.class);
		
		codCountryPhone = DefaultValue.number();
	}
	
	
	
	public static AreaPhoneInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, AreaPhoneInfo.class);
	}
	
	
	
	public static List<AreaPhoneInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, AreaPhoneInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codCountryPhone	^ (codCountryPhone	>>> 32));
		
		if (codArea != null)
			result = result * 31 + codArea.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof AreaPhoneInfo))
			return false;
		
		
		AreaPhoneInfo obj = (AreaPhoneInfo) o;		
		return (codCountryPhone == obj.codCountryPhone && isStringEqual(codArea, obj.codArea));
	}
}
