package br.com.mind5.masterData.areaPhoneSearch.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class AreanarchInfo extends InfoRecord implements Cloneable {
	public int codCountryPhone;
	public String codArea;
	public String txtArea;
	
	
	public AreanarchInfo() {
		super();
		
		codCountryPhone = DefaultValue.number();
	}
	
	
	
	public static AreanarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, AreanarchInfo.class);
	}
	
	
	
	public static List<AreanarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, AreanarchInfo.class);
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
		
		
		if (!(o instanceof AreanarchInfo))
			return false;
		
		
		AreanarchInfo obj = (AreanarchInfo) o;		
		return (codCountryPhone == obj.codCountryPhone && isStringEqual(codArea, obj.codArea));
	}
}
