package br.com.gda.payment.payOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.order.info.OrderCopier;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.model.decisionTree.RootOrderPay;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.payOrder.info.PayordInfo;

final class VisiPayordOrderPay extends ActionVisitorTemplateAction<PayordInfo, OrderInfo> {
	
	public VisiPayordOrderPay(Connection conn, String schemaName) {
		super(conn, schemaName, PayordInfo.class, OrderInfo.class);
	}
	
	
	@Override protected ActionStd<OrderInfo> getActionHook(DeciTreeOption<OrderInfo> option) {
		return new RootOrderPay(option).toAction();
	}
	
	
	
	@Override protected List<OrderInfo> toActionClassHook(List<PayordInfo> recordInfos) {
		return OrderCopier.copyFromPayord(recordInfos);
	}
	
	
	
	@Override protected List<PayordInfo> toBaseClassHook(List<PayordInfo> baseInfos, List<OrderInfo> results) {
		return baseInfos;
	}
}
