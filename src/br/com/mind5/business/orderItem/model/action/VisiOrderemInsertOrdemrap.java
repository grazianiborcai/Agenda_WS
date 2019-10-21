package br.com.mind5.business.orderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.info.OrderemMerger;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.orderItemSnapshot.model.decisionTree.RootOrdemrapInsert;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderemInsertOrdemrap extends ActionVisitorTemplateAction<OrderemInfo, OrdemrapInfo> {

	public VisiOrderemInsertOrdemrap(Connection conn, String schemaName) {
		super(conn, schemaName, OrderemInfo.class, OrdemrapInfo.class);
	}
	
	
	
	@Override protected ActionStd<OrdemrapInfo> getActionHook(DeciTreeOption<OrdemrapInfo> option) {
		return new RootOrdemrapInsert(option).toAction();
	}
	
	
	
	protected List<OrderemInfo> toBaseClassHook(List<OrderemInfo> baseInfos, List<OrdemrapInfo> results) {
		return OrderemMerger.mergeWithOrdemrap(results, baseInfos);
	}
}
