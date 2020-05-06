package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparCopier;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.model.decisionTree.RootStoparSelect;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipMerger;

final class VisiOrdmoipMergeStopar extends ActionVisitorTemplateMergeV2<OrdmoipInfo, StoparInfo> {
	
	public VisiOrdmoipMergeStopar(DeciTreeOption<OrdmoipInfo> option) {
		super(option, StoparInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoparInfo>> getTreeClassHook() {
		return RootStoparSelect.class;
	}
	
	
	
	@Override protected List<StoparInfo> toActionClassHook(List<OrdmoipInfo> baseInfos) {
		return StoparCopier.copyFromOrdmoip(baseInfos);	
	}
	
	
	
	@Override protected List<OrdmoipInfo> mergeHook(List<OrdmoipInfo> baseInfos, List<StoparInfo> selectedInfos) {	
		return OrdmoipMerger.mergeWithStopar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
