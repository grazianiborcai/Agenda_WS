package br.com.gda.business.cartSnapshot_.model.action;

import br.com.gda.business.cartSnapshot_.info.CartSnapInfo;
import br.com.gda.business.masterData.info.common.CartCateg;
import br.com.gda.model.action.commom.ActionVisitorTemplateFilter;

final class VisiCartSnapFilterCategTotal extends ActionVisitorTemplateFilter<CartSnapInfo> {
	
	@Override protected boolean filterOutHook(CartSnapInfo recordInfo) {
		if (recordInfo.codItemCateg == CartCateg.TOTAL.getCodCateg())
			return super.KEEP_RECORD;
		
		return super.SKIP_RECORD;
	}
}
