package br.com.mind5.payment.statusPayOrderItem.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.model.decisionTree.PayordemRootUpdateStatus;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemMerger;

public final class PaytusemVisiPayordemUpdate extends ActionVisitorTemplateMerge<PaytusemInfo, PayordemInfo> {
	
	public PaytusemVisiPayordemUpdate(DeciTreeOption<PaytusemInfo> option) {
		super(option, PayordemInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordemInfo>> getTreeClassHook() {
		return PayordemRootUpdateStatus.class;
	}
	
	
	
	@Override protected List<PaytusemInfo> mergeHook(List<PaytusemInfo> baseInfos, List<PayordemInfo> selectedInfos) {	
		return PaytusemMerger.mergeWithPayordem(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
