package br.com.mind5.business.storeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapCopier;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.model.decisionTree.RootPhonapSelect;
import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.info.StorapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorapMergePhonap extends ActionVisitorTemplateMergeV2<StorapInfo, PhonapInfo> {
	
	public VisiStorapMergePhonap(DeciTreeOption<StorapInfo> option) {
		super(option, PhonapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhonapInfo>> getTreeClassHook() {
		return RootPhonapSelect.class;
	}
	
	
	
	@Override protected List<PhonapInfo> toActionClassHook(List<StorapInfo> baseInfos) {
		return PhonapCopier.copyFromStorap(baseInfos);	
	}
	
	
	
	@Override protected List<StorapInfo> mergeHook(List<StorapInfo> baseInfos, List<PhonapInfo> selectedInfos) {	
		return StorapMerger.mergeWithPhonap(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
