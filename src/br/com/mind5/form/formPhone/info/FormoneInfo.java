package br.com.mind5.form.formPhone.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class FormoneInfo extends InfoRecord implements Cloneable {
	public String codCountry;
	public String codForm;
	
	
	public FormoneInfo() {
		super();
	}
	
	
	
	public static FormoneInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FormoneInfo.class);
	}
	
	
	
	public static List<FormoneInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FormoneInfo.class);
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
		
		
		if (!(o instanceof FormoneInfo))
			return false;
		
		
		FormoneInfo obj = (FormoneInfo) o;		
		return (codCountry.equals(obj.codCountry));
	}
}
