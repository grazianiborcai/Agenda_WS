package br.com.mind5.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateActionV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrder.info.RefuInfo;
import br.com.mind5.payment.refundOrder.model.decisionTree.RootRefuRefund;

final class VisiOrderRefuRefund extends ActionVisitorTemplateActionV1<OrderInfo, RefuInfo> {
	public VisiOrderRefuRefund(Connection conn, String schemaName) {
		super(conn, schemaName, OrderInfo.class, RefuInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<RefuInfo> getActionHook(DeciTreeOption<RefuInfo> option) {
		return new RootRefuRefund(option).toAction();
	}
	
	
	
	@Override protected List<OrderInfo> toBaseClassHook(List<OrderInfo> baseInfos, List<RefuInfo> results) {
		return baseInfos;
	}
}
