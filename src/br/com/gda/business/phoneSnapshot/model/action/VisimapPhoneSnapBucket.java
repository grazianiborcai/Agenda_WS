package br.com.gda.business.phoneSnapshot.model.action;

import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.model.action.ActionVisitorMap;

public final class VisimapPhoneSnapBucket implements ActionVisitorMap<PhoneSnapInfo, CountryPhoneInfo> {	

	@Override public CountryPhoneInfo buildMapKey(PhoneSnapInfo recordInfo) {
		return CountryPhoneInfo.copyFrom(recordInfo);
	}
}
