package br.com.gda.business.form.info;

import java.util.List;

import br.com.gda.info.InfoRecord;

public final class AddressFormInfo extends InfoRecord implements Cloneable {
	public String codCountry;
	public String codForm;
	
	
	public AddressFormInfo() {
	}
	
	
	
	public static AddressFormInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, AddressFormInfo.class);
	}
	
	
	
	public static List<AddressFormInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, AddressFormInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		return codCountry.hashCode();
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof AddressFormInfo))
			return false;
		
		
		AddressFormInfo obj = (AddressFormInfo) o;		
		return (codCountry.equals(obj.codCountry));
	}
}
