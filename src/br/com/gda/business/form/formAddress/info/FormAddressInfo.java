package br.com.gda.business.form.formAddress.info;

import java.util.List;

import br.com.gda.info.InfoRecord;

public final class FormAddressInfo extends InfoRecord implements Cloneable {
	public String codCountry;
	public String codForm;
	
	
	public FormAddressInfo() {
	}
	
	
	
	public static FormAddressInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FormAddressInfo.class);
	}
	
	
	
	public static List<FormAddressInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FormAddressInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		if (codCountry == null)
			return 0;
		
		return codCountry.hashCode();
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof FormAddressInfo))
			return false;
		
		
		FormAddressInfo obj = (FormAddressInfo) o;		
		return (codCountry.equals(obj.codCountry));
	}
}
