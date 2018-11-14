package br.com.gda.business.phone.model.action;

import br.com.gda.business.form.formPhone.info.FormPhoneInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.model.action.ActionVisitorMap;

public final class VisimapPhoneFormKey implements ActionVisitorMap<PhoneInfo, FormPhoneInfo> {	

	@Override public FormPhoneInfo buildMapKey(PhoneInfo recordInfo) {
		return FormPhoneInfo.copyFrom(recordInfo);
	}
}
