package br.com.mind5.business.storeTextSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.storeTextSnapshot.info.StorextsnapInfo;
import br.com.mind5.business.storeTextSnapshot.info.StorextsnapMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorextsnapVisiMergeToSelect extends ActionVisitorTemplateMerge<StorextsnapInfo, StorextsnapInfo> {
	
	public StorextsnapVisiMergeToSelect(DeciTreeOption<StorextsnapInfo> option) {
		super(option, StorextsnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StorextsnapInfo>> getVisitorClassHook() {
		return StorextsnapVisiDaoSelect.class;
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
