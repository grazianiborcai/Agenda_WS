package br.com.gda.business.phone.model.action;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.model.action.commom.ActionVisitorTemplateFilter;

final class VisiPhoneFilterDeleted extends ActionVisitorTemplateFilter<PhoneInfo> {
	
	@Override protected boolean filterOutHook(PhoneInfo recordInfo) {
		if (recordInfo.isDeleted)
			return super.KEEP_RECORD;
		
		return super.SKIP_RECORD;
	}
}
