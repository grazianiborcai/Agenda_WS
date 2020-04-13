package br.com.mind5.form.formAddress.info;

import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class FormessInfo extends InfoRecord implements Cloneable {
	public String codCountry;
	public String codForm;
	
	
	public FormessInfo() {
		super(FormessInfo.class);
	}
	
	
	
	public static FormessInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, FormessInfo.class);
	}
	
	
	
	public static List<FormessInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, FormessInfo.class);
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
		
		
		if (!(o instanceof FormessInfo))
			return false;
		
		
		FormessInfo obj = (FormessInfo) o;		
		return (codCountry.equals(obj.codCountry));
	}
}
