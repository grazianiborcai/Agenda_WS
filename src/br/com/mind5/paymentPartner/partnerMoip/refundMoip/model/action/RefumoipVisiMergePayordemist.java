package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;
import br.com.mind5.payment.payOrderItemList.model.decisionTree.PayordemistRootSelect;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipMerger;

public final class RefumoipVisiMergePayordemist extends ActionVisitorTemplateMerge<RefumoipInfo, PayordemistInfo> {
	
	public RefumoipVisiMergePayordemist(DeciTreeOption<RefumoipInfo> option) {
		super(option, PayordemistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordemistInfo>> getTreeClassHook() {
		return PayordemistRootSelect.class;
	}
	
	
	
	@Override protected List<RefumoipInfo> mergeHook(List<RefumoipInfo> baseInfos, List<PayordemistInfo> selectedInfos) {	
		return RefumoipMerger.mergeWithPayordemist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
