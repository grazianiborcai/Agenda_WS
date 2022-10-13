package br.com.mind5.business.personLegal.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class PeregSetterAddressKey extends InfoSetterTemplate<PeregInfo> {
	
	@Override protected PeregInfo setAttrHook(PeregInfo recordInfo) {
		recordInfo.addressData.codOwner = recordInfo.codOwner;
		recordInfo.addressData.codLegalPerson = recordInfo.codLegalPerson;
		recordInfo.addressData.username = recordInfo.username;
		recordInfo.addressData.codLanguage = recordInfo.codLanguage;
		
		recordInfo.addressData.codCustomer = DefaultValue.number();
		recordInfo.addressData.codStore = DefaultValue.number();
		recordInfo.addressData.codEmployee = DefaultValue.number();
		recordInfo.addressData.codUser = DefaultValue.number();
		recordInfo.addressData.codOwnerRef = DefaultValue.number();
		
		return recordInfo;
	}	
}
