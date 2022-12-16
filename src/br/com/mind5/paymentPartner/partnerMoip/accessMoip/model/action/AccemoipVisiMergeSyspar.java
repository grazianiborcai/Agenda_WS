package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.marketplacePartner.info.MktparInfo;
import br.com.mind5.payment.marketplacePartner.model.decisionTree.MktparRootSelect;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipMerger;

public final class AccemoipVisiMergeSyspar extends ActionVisitorTemplateMerge<AccemoipInfo, MktparInfo> {
	
	public AccemoipVisiMergeSyspar(DeciTreeOption<AccemoipInfo> option) {
		super(option, MktparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MktparInfo>> getTreeClassHook() {
		return MktparRootSelect.class;
	}
	
	
	
	@Override protected List<AccemoipInfo> mergeHook(List<AccemoipInfo> baseInfos, List<MktparInfo> selectedInfos) {	
		return AccemoipMerger.mergeWithSyspar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
