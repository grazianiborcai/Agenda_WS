package br.com.gda.business.address.model.action;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.model.action.commom.ActionVisitorTemplateFilter;

final class VisiAddressFilterDeleted extends ActionVisitorTemplateFilter<AddressInfo> {
	
	@Override protected boolean filterOutHook(AddressInfo recordInfo) {
		if (recordInfo.isDeleted)
			return super.KEEP_RECORD;
		
		return super.SKIP_RECORD;
	}
}
