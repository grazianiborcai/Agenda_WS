package br.com.mind5.payment.payOrderItem.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemMerger;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;
import br.com.mind5.payment.payOrderList.model.decisionTree.PayordistRootSelect;

public final class PayordemVisiMergePayordist extends ActionVisitorTemplateMerge<PayordemInfo, PayordistInfo> {
	
	public PayordemVisiMergePayordist(DeciTreeOption<PayordemInfo> option) {
		super(option, PayordistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordistInfo>> getTreeClassHook() {
		return PayordistRootSelect.class;
	}
	
	
	
	@Override protected List<PayordemInfo> mergeHook(List<PayordemInfo> baseInfos, List<PayordistInfo> selectedInfos) {	
		return PayordemMerger.mergeWithPayordist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
