package br.com.gda.business.order.model.action;

import br.com.gda.business.order.info.OrderFlag;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class StdVisitorOrderFlagHeader extends ActionVisitorTemplateEnforce<OrderInfo> {
	
	@Override protected OrderInfo enforceHook(OrderInfo recordInfo) {
		recordInfo.recordFlag = OrderFlag.HEADER.getId();
		return recordInfo;
	}
}
