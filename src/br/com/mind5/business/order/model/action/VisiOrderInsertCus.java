package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.decisionTree.RootCusInsertFromUser;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.model.action.ActionVisitorTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderInsertCus extends ActionVisitorTemplateActionV2<OrderInfo, CusInfo> {

	public VisiOrderInsertCus(DeciTreeOption<OrderInfo> option) {
		super(option, OrderInfo.class, CusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusInfo>> getTreeClassHook() {
		return RootCusInsertFromUser.class;
	}
	
	
	
	protected List<OrderInfo> toBaseClassHook(List<OrderInfo> baseInfos, List<CusInfo> results) {
		return OrderMerger.mergeWithCus(baseInfos, results);
	}
}
