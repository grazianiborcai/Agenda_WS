package br.com.mind5.business.orderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.info.OrderemMerger;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.orderItemSnapshot.model.decisionTree.OrdemrapRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderemVisiInsertOrdemrap extends ActionVisitorTemplateAction<OrderemInfo, OrdemrapInfo> {

	public OrderemVisiInsertOrdemrap(DeciTreeOption<OrderemInfo> option) {
		super(option, OrderemInfo.class, OrdemrapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdemrapInfo>> getTreeClassHook() {
		return OrdemrapRootInsert.class;
	}
	
	
	
	protected List<OrderemInfo> toBaseClassHook(List<OrderemInfo> baseInfos, List<OrdemrapInfo> results) {
		return OrderemMerger.mergeWithOrdemrap(baseInfos, results);
	}
}
