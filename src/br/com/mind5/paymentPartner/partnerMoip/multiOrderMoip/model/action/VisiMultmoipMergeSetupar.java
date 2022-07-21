package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.setupPartner.info.SetuparCopier;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.setupPartner.model.decisionTree.SetuparRootSelect;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipMerger;

final class VisiMultmoipMergeSetupar extends ActionVisitorTemplateMerge<MultmoipInfo, SetuparInfo> {
	
	public VisiMultmoipMergeSetupar(DeciTreeOption<MultmoipInfo> option) {
		super(option, SetuparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SetuparInfo>> getTreeClassHook() {
		return SetuparRootSelect.class;
	}
	
	
	
	@Override protected List<SetuparInfo> toActionClassHook(List<MultmoipInfo> baseInfos) {
		return SetuparCopier.copyFromMultmoip(baseInfos);	
	}
	
	
	
	@Override protected List<MultmoipInfo> mergeHook(List<MultmoipInfo> baseInfos, List<SetuparInfo> selectedInfos) {	
		return MultmoipMerger.mergeWithSetupar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
