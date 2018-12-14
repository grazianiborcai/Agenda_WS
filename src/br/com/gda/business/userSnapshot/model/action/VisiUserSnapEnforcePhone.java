package br.com.gda.business.userSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiUserSnapEnforcePhone extends ActionVisitorTemplateEnforce<UserSnapInfo> {
	@Override protected UserSnapInfo enforceHook(UserSnapInfo recordInfo) {
		List<PhoneSnapInfo> enforcedPhones = new ArrayList<>();
		
		for (PhoneSnapInfo eachPhone : recordInfo.phones) {
			PhoneSnapInfo enforcedPhone = enforce(eachPhone, recordInfo.codSnapshot);
			enforcedPhones.add(enforcedPhone);
		}
		
		recordInfo.phones = enforcedPhones;
		return recordInfo;
	}
	
	
	
	private PhoneSnapInfo enforce(PhoneSnapInfo recordInfo, long codSnapshot) {
		recordInfo.codSnapshot = codSnapshot;
		return recordInfo;
	}
}
