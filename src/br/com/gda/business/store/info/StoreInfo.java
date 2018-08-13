package br.com.gda.business.store.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.helper.RecordMode;
import br.com.gda.info.InfoRecord;

public final class StoreInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;	
	public String cnpj;
	public String inscrMun;
	public String inscrEst;
	public String razaoSocial;
	public String name;
	public String address1;
	public String address2;
	public long   postalCode;
	public String city;
	public String codCountry;
	public String txtCountry;
	public String stateProvince;
	public String phone;
	public String codCurr;
	public String txtCurr;
	public String codPayment;
	public double latitude;
	public double longitude;
	public String codTimezone;
	public String codLanguage;
	public String recordMode;
	
	
	public StoreInfo() {
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		postalCode = DefaultValue.number();
		latitude = DefaultValue.number();;
		longitude = DefaultValue.number();;
		codLanguage = Language.getDefaultLanguage();
		recordMode = RecordMode.RECORD_OK;		
	}
	
	
	
	public static StoreInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StoreInfo.class);
	}
	
	
	
	public static List<StoreInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StoreInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore ^ (codStore >>> 32));
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StoreInfo))
			return false;
		
		
		StoreInfo obj = (StoreInfo) o;		
		return (codOwner == obj.codOwner && codStore == obj.codStore);
	}
}
