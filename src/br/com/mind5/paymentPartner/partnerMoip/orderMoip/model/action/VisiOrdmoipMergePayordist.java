package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;
import br.com.mind5.payment.payOrderList.model.decisionTree.PayordistRootSelect;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipMerger;

final class VisiOrdmoipMergePayordist extends ActionVisitorTemplateMerge<OrdmoipInfo, PayordistInfo> {
	
	public VisiOrdmoipMergePayordist(DeciTreeOption<OrdmoipInfo> option) {
		super(option, PayordistInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayordistInfo>> getTreeClassHook() {
		return PayordistRootSelect.class;
	}
	
	
	
	@Override protected List<OrdmoipInfo> mergeHook(List<OrdmoipInfo> baseInfos, List<PayordistInfo> selectedInfos) {	
		return OrdmoipMerger.mergeWithPayordist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
