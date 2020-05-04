package br.com.mind5.payment.refundOrderItem.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.decisionTree.RootPayordemSelect;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.payment.refundOrderItem.info.RefemMerger;

final class VisiRefemMergePayordem extends ActionVisitorTemplateMergeV2<RefemInfo, PayordemInfo> {
	
	public VisiRefemMergePayordem(DeciTreeOption<RefemInfo> option) {
		super(option, PayordemInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordemInfo>> getTreeClassHook() {
		return RootPayordemSelect.class;
	}
	
	
	
	@Override protected List<RefemInfo> mergeHook(List<RefemInfo> baseInfos, List<PayordemInfo> selectedInfos) {
		return RefemMerger.mergeWithPayordem(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
