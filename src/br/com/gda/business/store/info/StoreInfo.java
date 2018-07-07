package br.com.gda.business.store.info;

import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.helper.RecordMode;
import br.com.gda.info.RecordInfo;

public final class StoreInfo extends RecordInfo implements Cloneable {
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
		this.codOwner = DefaultValue.number();
		this.codStore = DefaultValue.number();
		this.postalCode = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
		this.recordMode = RecordMode.RECORD_OK;		
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
}
