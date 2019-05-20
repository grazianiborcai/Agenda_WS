package br.com.gda.business.userSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiUserSnapEnforcePhone extends ActionVisitorTemplateEnforce<UserSnapInfo> {
	@Override protected UserSnapInfo enforceHook(UserSnapInfo recordInfo) {
		List<PhonapInfo> enforcedPhones = new ArrayList<>();
		
		for (PhonapInfo eachPhone : recordInfo.phones) {
			PhonapInfo enforcedPhone = enforce(eachPhone, recordInfo.codSnapshot);
			enforcedPhones.add(enforcedPhone);
		}
		
		recordInfo.phones = enforcedPhones;
		return recordInfo;
	}
	
	
	
	private PhonapInfo enforce(PhonapInfo recordInfo, long codSnapshot) {
		recordInfo.codSnapshot = codSnapshot;
		return recordInfo;
	}
}
