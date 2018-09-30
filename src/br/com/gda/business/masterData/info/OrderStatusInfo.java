package br.com.gda.business.masterData.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class OrderStatusInfo extends InfoRecord implements Cloneable {
	public String codOrderStatus;
	public String txtOrderStatus;
	public String codLanguage;
	
	
	public OrderStatusInfo() {
		this.codLanguage = DefaultValue.language();
	}
	
	
	
	public static CountryInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CountryInfo.class);
	}
	
	
	
	public static List<CountryInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CountryInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		return codOrderStatus.hashCode();
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CountryInfo))
			return false;
		
		
		CountryInfo obj = (CountryInfo) o;		
		return (codOrderStatus.equals(obj.codCountry));
	}
}
