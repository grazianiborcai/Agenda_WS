package br.com.gda.business.order.model.action;

import br.com.gda.business.masterData.info.CartCateg;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.model.action.ActionVisitorTemplateFilter;

final class StdVisitorOrderFilterExtra extends ActionVisitorTemplateFilter<OrderInfo> {
	
	@Override protected boolean filterOutHook(OrderInfo recordInfo) {
		if (recordInfo.codItemCateg != CartCateg.ITEM.getCodCateg())
			return super.KEEP_RECORD;
		
		return super.SKIP_RECORD;
	}
}
