package br.com.gda.business.phone.model.action;

import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.model.action.ActionVisitorMap;

public final class VisimapPhoneBucket implements ActionVisitorMap<PhoneInfo, CountryPhoneInfo> {	

	@Override public CountryPhoneInfo buildMapKey(PhoneInfo recordInfo) {
		return CountryPhoneInfo.copyFrom(recordInfo);
	}
}
