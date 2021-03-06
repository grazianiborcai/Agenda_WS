package br.com.mind5.business.storeTextSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.storeTextSnapshot.info.StorextsnapInfo;
import br.com.mind5.business.storeTextSnapshot.info.StorextsnapMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorextsnapMergeToSelect extends ActionVisitorTemplateMerge<StorextsnapInfo, StorextsnapInfo> {
	
	public VisiStorextsnapMergeToSelect(DeciTreeOption<StorextsnapInfo> option) {
		super(option, StorextsnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StorextsnapInfo>> getActionClassHook() {
		return StdStorextsnapDaoSelect.class;
	}
	
	
	
	@Override protected List<StorextsnapInfo> toActionClassHook(List<StorextsnapInfo> baseInfos) {
		return baseInfos;	
	}	
	
	
	
	@Override protected List<StorextsnapInfo> mergeHook(List<StorextsnapInfo> baseInfos, List<StorextsnapInfo> selectedInfos) {	
		return StorextsnapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
