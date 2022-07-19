package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action;

import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapCopier;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.model.decisionTree.PhonapRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipMerger;

public final class CremoipVisiMergePhonap extends ActionVisitorTemplateMerge<CremoipInfo, PhonapInfo> {
	
	public CremoipVisiMergePhonap(DeciTreeOption<CremoipInfo> option) {
		super(option, PhonapInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhonapInfo>> getTreeClassHook() {
		return PhonapRootSelect.class;
	}
	
	
	
	@Override protected List<PhonapInfo> toActionClassHook(List<CremoipInfo> baseInfos) {
		return PhonapCopier.copyFromCremoip(baseInfos);	
	}
	
	
	
	@Override protected List<CremoipInfo> mergeHook(List<CremoipInfo> baseInfos, List<PhonapInfo> selectedInfos) {	
		return CremoipMerger.mergeWithPhonap(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
