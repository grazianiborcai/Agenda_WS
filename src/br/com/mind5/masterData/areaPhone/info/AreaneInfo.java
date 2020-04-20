package br.com.mind5.masterData.areaPhone.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class AreaneInfo extends InfoRecord implements Cloneable {
	public int codCountryPhone;
	public String codArea;
	public String txtArea;
	
	
	public AreaneInfo() {
		super();
		
		codCountryPhone = DefaultValue.number();
	}
	
	
	
	public static AreaneInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, AreaneInfo.class);
	}
	
	
	
	public static List<AreaneInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, AreaneInfo.class);
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
		
		
		if (!(o instanceof AreaneInfo))
			return false;
		
		
		AreaneInfo obj = (AreaneInfo) o;		
		return (codCountryPhone == obj.codCountryPhone && isStringEqual(codArea, obj.codArea));
	}
}
