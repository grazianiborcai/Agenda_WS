package br.com.gda.payment.refundOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.order.info.OrderCopier;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.model.decisionTree.RootOrderRefunding;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.refundOrder.info.RefuInfo;

final class VisiRefuOrderRefunding extends ActionVisitorTemplateAction<RefuInfo, OrderInfo> {
	
	public VisiRefuOrderRefunding(Connection conn, String schemaName) {
		super(conn, schemaName, RefuInfo.class, OrderInfo.class);
	}
	
	
	
	@Override protected ActionStd<OrderInfo> getActionHook(DeciTreeOption<OrderInfo> option) {
		return new RootOrderRefunding(option).toAction();
	}
	
	
	
	protected List<OrderInfo> toActionClassHook(List<RefuInfo> recordInfos) {
		return OrderCopier.copyFromRefu(recordInfos);
	}
	
	
	
	@Override protected List<RefuInfo> toBaseClassHook(List<RefuInfo> baseInfos, List<OrderInfo> results) {	
		return baseInfos;
	}
}
