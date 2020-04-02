package br.com.mind5.payment.payOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.order.info.OrderCopier;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.decisionTree.RootOrderPay;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class VisiPayordOrderPay extends ActionVisitorTemplateAction<PayordInfo, OrderInfo> {
	
	public VisiPayordOrderPay(Connection conn, String schemaName) {
		super(conn, schemaName, PayordInfo.class, OrderInfo.class);
	}
	
	
	@Override protected ActionStdV1<OrderInfo> getActionHook(DeciTreeOption<OrderInfo> option) {
		return new RootOrderPay(option).toAction();
	}
	
	
	
	@Override protected List<OrderInfo> toActionClassHook(List<PayordInfo> recordInfos) {
		return OrderCopier.copyFromPayord(recordInfos);
	}
	
	
	
	@Override protected List<PayordInfo> toBaseClassHook(List<PayordInfo> baseInfos, List<OrderInfo> results) {
		return baseInfos;
	}
}
