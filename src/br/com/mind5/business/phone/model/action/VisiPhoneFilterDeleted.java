package br.com.mind5.business.phone.model.action;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.model.action.commom.ActionVisitorTemplateFilter;

final class VisiPhoneFilterDeleted extends ActionVisitorTemplateFilter<PhoneInfo> {
	
	@Override protected boolean filterOutHook(PhoneInfo recordInfo) {
		if (recordInfo.isDeleted)
			return super.KEEP_RECORD;
		
		return super.SKIP_RECORD;
	}
}
