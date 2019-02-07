package br.com.gda.business.cartSnapshot.model.action;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.business.masterData.info.common.CartCateg;
import br.com.gda.model.action.commom.ActionVisitorTemplateFilter;

final class VisiCartSnapFilterCategFee extends ActionVisitorTemplateFilter<CartSnapInfo> {
	
	@Override protected boolean filterOutHook(CartSnapInfo recordInfo) {
		if (recordInfo.codItemCateg == CartCateg.SERVICE_FEE.getCodCateg())
			return super.KEEP_RECORD;
		
		return super.SKIP_RECORD;
	}
}
