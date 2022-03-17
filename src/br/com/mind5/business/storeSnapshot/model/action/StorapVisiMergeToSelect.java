package br.com.mind5.business.storeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.info.StorapMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorapVisiMergeToSelect extends ActionVisitorTemplateMerge<StorapInfo, StorapInfo> {
	
	public StorapVisiMergeToSelect(DeciTreeOption<StorapInfo> option) {
		super(option, StorapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StorapInfo>> getVisitorClassHook() {
		return StorapVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StorapInfo> mergeHook(List<StorapInfo> baseInfos, List<StorapInfo> selectedInfos) {	
		return StorapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}	
}
