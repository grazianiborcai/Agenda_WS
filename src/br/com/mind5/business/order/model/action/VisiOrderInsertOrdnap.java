package br.com.mind5.business.order.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.business.orderSnapshot.model.decisionTree.RootOrdnapInsert;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderInsertOrdnap extends ActionVisitorTemplateAction<OrderInfo, OrdnapInfo> {

	public VisiOrderInsertOrdnap(Connection conn, String schemaName) {
		super(conn, schemaName, OrderInfo.class, OrdnapInfo.class);
	}
	
	
	
	@Override protected ActionStd<OrdnapInfo> getActionHook(DeciTreeOption<OrdnapInfo> option) {
		return new RootOrdnapInsert(option).toAction();
	}
	
	
	
	protected List<OrderInfo> toBaseClassHook(List<OrderInfo> baseInfos, List<OrdnapInfo> results) {
		return OrderMerger.mergeWithOrdnap(baseInfos, results);
	}
}
