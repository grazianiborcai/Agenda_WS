package br.com.gda.business.address.model.action;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.model.action.ActionVisitorTemplateFilter;

final class VisiAddressFilterNew extends ActionVisitorTemplateFilter<AddressInfo> {
	
	@Override protected boolean filterOutHook(AddressInfo recordInfo) {
		if (recordInfo.codAddress <= 0)
			return super.KEEP_RECORD;
		
		return super.SKIP_RECORD;
	}
}
