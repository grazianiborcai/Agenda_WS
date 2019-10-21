package br.com.mind5.business.form.formPhone.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class FormPhoneInfo extends InfoRecord implements Cloneable {
	public String codCountry;
	public String codForm;
	
	
	public FormPhoneInfo() {
		super(FormPhoneInfo.class);
	}
	
	
	
	public static FormPhoneInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FormPhoneInfo.class);
	}
	
	
	
	public static List<FormPhoneInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FormPhoneInfo.class);
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
		
		
		if (!(o instanceof FormPhoneInfo))
			return false;
		
		
		FormPhoneInfo obj = (FormPhoneInfo) o;		
		return (codCountry.equals(obj.codCountry));
	}
}
