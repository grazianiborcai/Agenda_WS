package br.com.gda.business.userSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddressSnapInfo;
import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiUserSnapEnforceAddress extends ActionVisitorTemplateEnforce<UserSnapInfo> {
	@Override protected UserSnapInfo enforceHook(UserSnapInfo recordInfo) {
		List<AddressSnapInfo> enforcedAddresses = new ArrayList<>();
		
		for (AddressSnapInfo eachAddress : recordInfo.addresses) {
			AddressSnapInfo enforcedAddress = enforce(eachAddress, recordInfo.codSnapshot);
			enforcedAddresses.add(enforcedAddress);
		}
		
		recordInfo.addresses = enforcedAddresses;
		return recordInfo;
	}
	
	
	
	private AddressSnapInfo enforce(AddressSnapInfo recordInfo, long codSnapshot) {
		recordInfo.codSnapshot = codSnapshot;
		return recordInfo;
	}
}
