package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;
import br.com.mind5.payment.payOrderItemList.model.decisionTree.PayordemistRootSearch;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipMerger;

final class VisiMultmoipMergePayordemist extends ActionVisitorTemplateMerge<MultmoipInfo, PayordemistInfo> {
	
	public VisiMultmoipMergePayordemist(DeciTreeOption<MultmoipInfo> option) {
		super(option, PayordemistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordemistInfo>> getTreeClassHook() {
		return PayordemistRootSearch.class;
	}
	
	
	
	@Override protected List<MultmoipInfo> mergeHook(List<MultmoipInfo> baseInfos, List<PayordemistInfo> selectedInfos) {	
		return MultmoipMerger.mergeWithPayordemist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
