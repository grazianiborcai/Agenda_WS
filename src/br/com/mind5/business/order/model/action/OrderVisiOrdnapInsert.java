package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.business.orderSnapshot.model.decisionTree.OrdnapRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderVisiOrdnapInsert extends ActionVisitorTemplateAction<OrderInfo, OrdnapInfo> {

	public OrderVisiOrdnapInsert(DeciTreeOption<OrderInfo> option) {
		super(option, OrderInfo.class, OrdnapInfo.class);
	}
	
	
	@Override protected Class<? extends DeciTree<OrdnapInfo>> getTreeClassHook() {
		return OrdnapRootInsert.class;
	}
	
	
	
	protected List<OrderInfo> toBaseClassHook(List<OrderInfo> baseInfos, List<OrdnapInfo> results) {
		return OrderMerger.mergeWithOrdnap(baseInfos, results);
	}
}
