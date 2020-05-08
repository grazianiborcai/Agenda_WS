package br.com.mind5.business.order.model.action;

import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.order.info.OrderMerger;
import br.com.mind5.masterData.refundPolicyGroupHeader.info.RefugraderInfo;
import br.com.mind5.masterData.refundPolicyGroupHeader.model.decisionTree.RootRefugraderSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrderMergeRefugrader extends ActionVisitorTemplateMergeV2<OrderInfo, RefugraderInfo> {
	
	public VisiOrderMergeRefugrader(DeciTreeOption<OrderInfo> option) {
		super(option, RefugraderInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefugraderInfo>> getTreeClassHook() {
		return RootRefugraderSelect.class;
	}
	
	
	
	@Override protected List<OrderInfo> mergeHook(List<OrderInfo> baseInfos, List<RefugraderInfo> selectedInfos) {	
		return OrderMerger.mergeWithRefugrader(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
