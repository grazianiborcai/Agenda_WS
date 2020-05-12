package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.business.orderSnapshot.model.decisionTree.RootOrdnapInsert;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderOrdnapInsert extends ActionVisitorTemplateActionV2<OrderInfo, OrdnapInfo> {

	public VisiOrderOrdnapInsert(DeciTreeOption<OrderInfo> option) {
		super(option, OrderInfo.class, OrdnapInfo.class);
	}
	
	
	@Override protected Class<? extends DeciTree<OrdnapInfo>> getTreeClassHook() {
		return RootOrdnapInsert.class;
	}
	
	
	
	protected List<OrderInfo> toBaseClassHook(List<OrderInfo> baseInfos, List<OrdnapInfo> results) {
		return OrderMerger.mergeWithOrdnap(baseInfos, results);
	}
}
