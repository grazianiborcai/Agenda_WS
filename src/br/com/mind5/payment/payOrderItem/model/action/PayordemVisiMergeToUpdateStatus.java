package br.com.mind5.payment.payOrderItem.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemMerger;

public final class PayordemVisiMergeToUpdateStatus extends ActionVisitorTemplateMerge<PayordemInfo, PayordemInfo> {
	
	public PayordemVisiMergeToUpdateStatus(DeciTreeOption<PayordemInfo> option) {
		super(option, PayordemInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<PayordemInfo>> getVisitorClassHook() {
		return PayordemVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<PayordemInfo> mergeHook(List<PayordemInfo> baseInfos, List<PayordemInfo> selectedInfos) {	
		return PayordemMerger.mergeToUpdateStatus(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
