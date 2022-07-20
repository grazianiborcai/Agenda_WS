package br.com.mind5.payment.payOrder.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderCopier;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.model.decisionTree.OrderRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.info.PayordMerger;

public final class PayordVisiMergeOrder extends ActionVisitorTemplateMerge<PayordInfo, OrderInfo> {
	
	public PayordVisiMergeOrder(DeciTreeOption<PayordInfo> option) {
		super(option, OrderInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderInfo>> getTreeClassHook() {
		return OrderRootSelect.class;
	}
	
	
	
	@Override protected List<OrderInfo> toActionClassHook(List<PayordInfo> baseInfos) {
		return OrderCopier.copyFromPayord(baseInfos);	
	}
	
	
	
	@Override protected List<PayordInfo> mergeHook(List<PayordInfo> baseInfos, List<OrderInfo> selectedInfos) {	
		return PayordMerger.mergeWithOrder(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
