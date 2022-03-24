package br.com.mind5.business.orderItem.model.action;

import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.decisionTree.OrderemNodeCancel;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderemVisiNodeCancel extends ActionVisitorTemplateAction<OrderemInfo, OrderemInfo> {

	public OrderemVisiNodeCancel(DeciTreeOption<OrderemInfo> option) {
		super(option, OrderemInfo.class, OrderemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderemInfo>> getTreeClassHook() {
		return OrderemNodeCancel.class;
	}
	
	
	
	@Override protected List<OrderemInfo> toBaseClassHook(List<OrderemInfo> baseInfos, List<OrderemInfo> results) {
		return results;
	}
}
