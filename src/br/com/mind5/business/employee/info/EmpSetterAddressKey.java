package br.com.mind5.business.employee.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class EmpSetterAddressKey extends InfoSetterTemplate<EmpInfo> {
	
	@Override protected EmpInfo setAttrHook(EmpInfo recordInfo) {
		for (AddressInfo eachAddress : recordInfo.addresses) {
			eachAddress.codOwner = recordInfo.codOwner;
			eachAddress.codEmployee = recordInfo.codEmployee;
			eachAddress.username = recordInfo.username;
			eachAddress.codLanguage = recordInfo.codLanguage;
		//	eachAddress.lastChangedBy = recordInfo.lastChangedBy;	//TODO: remover
		}
		
		return recordInfo;
	}
}
