package br.com.gda.business.phone.info;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class PhoneInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codPhone;
	public long codCustomer;
	public long codStore;
	public long codEmployee;
	public String codCountry;
	public String fullNumber;
	public int codCountryPhone;
	public int codArea;				//TODO: Remover
	public String number;			//TODO: Remover
	public String recordMode;
	public LocalDateTime lastChanged;
	public String codForm;
	public boolean isDeleted;
	
	
	public PhoneInfo() {
		codOwner = DefaultValue.number();
		codPhone = DefaultValue.number();
		codStore = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codCountryPhone = DefaultValue.number();
		codArea = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		isDeleted = DefaultValue.boole();
	}
	
	
	
	public static PhoneInfo copyFrom(Object sourceObj) {
		PhoneInfo result = copyFrom(sourceObj, PhoneInfo.class);
		return setAttr(result);
	}
	
	
	
	public static List<PhoneInfo> copyFrom(List<?> sourceObjs) {
		List<PhoneInfo> results = copyFrom(sourceObjs, PhoneInfo.class);
		
		for (PhoneInfo eachPhone : results) {
			setAttr(eachPhone);
		}
		
		return results;
	}
	
	
	
	private static PhoneInfo setAttr(PhoneInfo recordInfo) {		
		PhoneSetterAll_ setterAttr = new PhoneSetterAll_();
		setterAttr.setAttr(recordInfo);
		
		return recordInfo;
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codCountryPhone ^ (codCountryPhone >>> 32));
		
		if (fullNumber != null)
			result = result * 31 + fullNumber.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PhoneInfo))
			return false;
		
		
		PhoneInfo obj = (PhoneInfo) o;		
		return (codCountryPhone == obj.codCountryPhone && isStringEqual(fullNumber, obj.fullNumber));
	}	
}
