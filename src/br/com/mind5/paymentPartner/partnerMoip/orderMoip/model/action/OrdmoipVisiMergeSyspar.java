package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.marketplacePartner.info.MktparCopier;
import br.com.mind5.payment.marketplacePartner.info.MktparInfo;
import br.com.mind5.payment.marketplacePartner.model.decisionTree.MktparRootSelect;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipMerger;

public final class OrdmoipVisiMergeSyspar extends ActionVisitorTemplateMerge<OrdmoipInfo, MktparInfo> {
	
	public OrdmoipVisiMergeSyspar(DeciTreeOption<OrdmoipInfo> option) {
		super(option, MktparInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<MktparInfo>> getTreeClassHook() {
		return MktparRootSelect.class;
	}
	
	
	
	@Override protected List<MktparInfo> toActionClassHook(List<OrdmoipInfo> recordInfos) {
		return MktparCopier.copyFromOrdmoip(recordInfos);	
	}
	
	
	
	@Override protected List<OrdmoipInfo> mergeHook(List<OrdmoipInfo> baseInfos, List<MktparInfo> selectedInfos) {	
		return OrdmoipMerger.mergeWithSyspar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
