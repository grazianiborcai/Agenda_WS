package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.model.decisionTree.StoparRootSelect;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipMerger;

final class VisiRefumoipMergeStopar extends ActionVisitorTemplateMerge<RefumoipInfo, StoparInfo> {
	
	public VisiRefumoipMergeStopar(DeciTreeOption<RefumoipInfo> option) {
		super(option, StoparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoparInfo>> getTreeClassHook() {
		return StoparRootSelect.class;
	}
	
	
	
	@Override protected List<RefumoipInfo> mergeHook(List<RefumoipInfo> baseInfos, List<StoparInfo> selectedInfos) {	
		return RefumoipMerger.mergeWithStopar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
