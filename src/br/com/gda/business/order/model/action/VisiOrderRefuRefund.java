package br.com.gda.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.refundOrder.info.RefuInfo;
import br.com.gda.payment.refundOrder.model.decisionTree.RootRefuRefund;

final class VisiOrderRefuRefund extends ActionVisitorTemplateAction<OrderInfo, RefuInfo> {
	public VisiOrderRefuRefund(Connection conn, String schemaName) {
		super(conn, schemaName, OrderInfo.class, RefuInfo.class);
	}
	
	
	
	@Override protected ActionStd<RefuInfo> getActionHook(DeciTreeOption<RefuInfo> option) {
		return new RootRefuRefund(option).toAction();
	}
	
	
	
	@Override protected List<OrderInfo> toBaseClassHook(List<OrderInfo> baseInfos, List<RefuInfo> results) {
		return baseInfos;
	}
}
