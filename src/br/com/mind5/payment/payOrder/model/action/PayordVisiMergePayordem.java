package br.com.mind5.payment.payOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.info.PayordMerger;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.decisionTree.PayordemRootSearchPayord;

public final class PayordVisiMergePayordem extends ActionVisitorTemplateMerge<PayordInfo, PayordemInfo> {
	
	public PayordVisiMergePayordem(DeciTreeOption<PayordInfo> option) {
		super(option, PayordemInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordemInfo>> getTreeClassHook() {
		return PayordemRootSearchPayord.class;
	}
	
	
	
	@Override protected List<PayordInfo> mergeHook(List<PayordInfo> baseInfos, List<PayordemInfo> selectedInfos) {	
		return PayordMerger.mergeWithPayordem(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
