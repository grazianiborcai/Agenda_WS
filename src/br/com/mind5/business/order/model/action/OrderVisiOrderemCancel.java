package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.business.orderItem.info.OrderemCopier;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.model.decisionTree.OrderemRootCancel;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrderVisiOrderemCancel extends ActionVisitorTemplateAction<OrderInfo, OrderemInfo> {
	
	public OrderVisiOrderemCancel(DeciTreeOption<OrderInfo> option) {
		super(option, OrderInfo.class, OrderemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderemInfo>> getTreeClassHook() {
		return OrderemRootCancel.class;
	}
	
	
	
	@Override protected List<OrderemInfo> toActionClassHook(List<OrderInfo> baseInfos) {
		return OrderemCopier.copyFromOrder(baseInfos);
	}
	
	
	
	@Override protected List<OrderInfo> toBaseClassHook(List<OrderInfo> baseInfos, List<OrderemInfo> results) {
		return OrderMerger.mergeWithOrderem(baseInfos, results);
	}
}
