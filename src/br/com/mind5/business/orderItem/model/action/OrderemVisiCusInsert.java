package br.com.mind5.business.orderItem.model.action;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.decisionTree.CusRootInsertFromOrderem;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.info.OrderemMerger;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderemVisiCusInsert extends ActionVisitorTemplateAction<OrderemInfo, CusInfo> {

	public OrderemVisiCusInsert(DeciTreeOption<OrderemInfo> option) {
		super(option, OrderemInfo.class, CusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusInfo>> getTreeClassHook() {
		return CusRootInsertFromOrderem.class;
	}
	
	
	
	protected List<OrderemInfo> toBaseClassHook(List<OrderemInfo> baseInfos, List<CusInfo> results) {
		return OrderemMerger.mergeWithCus(baseInfos, results);
	}
}
