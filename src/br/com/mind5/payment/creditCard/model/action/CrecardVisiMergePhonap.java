package br.com.mind5.payment.creditCard.model.action;

import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapCopier;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.model.decisionTree.PhonapRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardMerger;

public final class CrecardVisiMergePhonap extends ActionVisitorTemplateMerge<CrecardInfo, PhonapInfo> {
	
	public CrecardVisiMergePhonap(DeciTreeOption<CrecardInfo> option) {
		super(option, PhonapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhonapInfo>> getTreeClassHook() {
		return PhonapRootSelect.class;
	}
	
	
	
	@Override protected List<PhonapInfo> toActionClassHook(List<CrecardInfo> baseInfos) {
		return PhonapCopier.copyFromCrecard(baseInfos);	
	}
	
	
	
	@Override protected List<CrecardInfo> mergeHook(List<CrecardInfo> baseInfos, List<PhonapInfo> selectedInfos) {	
		return CrecardMerger.mergeWithPhonap(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
