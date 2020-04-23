package br.com.mind5.business.employee.info;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class EmpSetterPhoneKey extends InfoSetterTemplate<EmpInfo> {
	
	@Override protected EmpInfo setAttrHook(EmpInfo recordInfo) {
		for (PhoneInfo eachPhone : recordInfo.phones) {
			eachPhone.codOwner = recordInfo.codOwner;
			eachPhone.codEmployee = recordInfo.codEmployee;
			eachPhone.codLanguage = recordInfo.codLanguage;
			eachPhone.username = recordInfo.username;
		}
		
		return recordInfo;
	}
}
