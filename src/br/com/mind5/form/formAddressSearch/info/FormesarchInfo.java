package br.com.mind5.form.formAddressSearch.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class FormesarchInfo extends InfoRecord implements Cloneable {
	public String codCountry;
	public String codForm;
	
	
	public FormesarchInfo() {
		super();
	}
	
	
	
	public static FormesarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FormesarchInfo.class);
	}
	
	
	
	public static List<FormesarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FormesarchInfo.class);
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
		
		
		if (!(o instanceof FormesarchInfo))
			return false;
		
		
		FormesarchInfo obj = (FormesarchInfo) o;		
		return (codCountry.equals(obj.codCountry));
	}
}
