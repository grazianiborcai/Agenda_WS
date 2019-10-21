package br.com.mind5.business.phone.model.action;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.model.action.commom.ActionVisitorTemplateFilter;

final class VisiPhoneFilterOld extends ActionVisitorTemplateFilter<PhoneInfo> {
	
	@Override protected boolean filterOutHook(PhoneInfo recordInfo) {
		if (recordInfo.codPhone > 0)
			return super.KEEP_RECORD;
		
		return super.SKIP_RECORD;
	}
}
