package br.com.gda.business.customer.info;

import java.time.LocalDate;

import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.helper.RecordMode;

public final class CusInfo implements Cloneable {
	public long codOwner;
	public long codCustomer;
	public String cpf;
	public String name;
	public int codGender;
	public String txtGender;
	public LocalDate birthDate;
	public String email;
	public String address1;
	public String address2;
	public long postalCode;
	public String city;
	public String codCountry;
	public String txtCountry;
	public String stateProvince;
	public String phone;
	public String codLanguage;
	public String recordMode;
	
	
	public CusInfo() {
		this.codOwner = DefaultValue.number();
		this.codCustomer = DefaultValue.number();
		this.codGender = DefaultValue.number();
		this.postalCode = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
		this.recordMode = RecordMode.RECORD_OK;		
	}
	
	
	
	public OwnerInfo toOwnerInfo() {
		OwnerInfo owner = new OwnerInfo();
		owner.codOwner = codOwner;
		return owner;
	}
	
	
	
	public GenderInfo toGenderInfo() {
		GenderInfo gender = new GenderInfo();
		gender.codGender = codGender;
		gender.txtGender = txtGender;
		gender.codLanguage = codLanguage;
		return gender;
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
