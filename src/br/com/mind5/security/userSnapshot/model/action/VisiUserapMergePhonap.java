package br.com.mind5.security.userSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapCopier;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.model.decisionTree.PhonapRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.userSnapshot.info.UserapMerger;

final class VisiUserapMergePhonap extends ActionVisitorTemplateMerge<UserapInfo, PhonapInfo> {
	
	public VisiUserapMergePhonap(DeciTreeOption<UserapInfo> option) {
		super(option, PhonapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhonapInfo>> getTreeClassHook() {
		return PhonapRootSearch.class;
	}
	
	
	
	@Override protected List<PhonapInfo> toActionClassHook(List<UserapInfo> baseInfos) {
		return PhonapCopier.copyFromUserapKey(baseInfos);
	}	
	
	
	
	@Override protected List<UserapInfo> mergeHook(List<UserapInfo> baseInfos, List<PhonapInfo> selectedInfos) {	
		return UserapMerger.mergeWithPhonap(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
