package br.com.gda.business.order.model.action;

import br.com.gda.business.order.info.OrderFlag;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiOrderFlagItem extends ActionVisitorTemplateEnforce<OrderInfo> {
	
	@Override protected OrderInfo enforceHook(OrderInfo recordInfo) {
		//TODO: mover para uma classe Setter
		recordInfo.recordFlag = OrderFlag.ITEM.getFlagId();
		return recordInfo;
	}
}
