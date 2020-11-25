package br.com.mind5.business.orderItem.model.action;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.decisionTree.RootCusInsertFromOrder;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.info.OrderemMerger;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderemCusInsert extends ActionVisitorTemplateAction<OrderemInfo, CusInfo> {

	public VisiOrderemCusInsert(DeciTreeOption<OrderemInfo> option) {
		super(option, OrderemInfo.class, CusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusInfo>> getTreeClassHook() {
		return RootCusInsertFromOrder.class;
	}
	
	
	
	protected List<OrderemInfo> toBaseClassHook(List<OrderemInfo> baseInfos, List<CusInfo> results) {
		return OrderemMerger.mergeWithCus(baseInfos, results);
	}
}
