package br.com.mind5.payment.refundOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.order.info.OrderCopier;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.decisionTree.RootOrderRefunding;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateActionV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrder.info.RefuInfo;

final class VisiRefuOrderRefunding extends ActionVisitorTemplateActionV1<RefuInfo, OrderInfo> {
	
	public VisiRefuOrderRefunding(Connection conn, String schemaName) {
		super(conn, schemaName, RefuInfo.class, OrderInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<OrderInfo> getActionHook(DeciTreeOption<OrderInfo> option) {
		return new RootOrderRefunding(option).toAction();
	}
	
	
	
	protected List<OrderInfo> toActionClassHook(List<RefuInfo> recordInfos) {
		return OrderCopier.copyFromRefu(recordInfos);
	}
	
	
	
	@Override protected List<RefuInfo> toBaseClassHook(List<RefuInfo> baseInfos, List<OrderInfo> results) {	
		return baseInfos;
	}
}
