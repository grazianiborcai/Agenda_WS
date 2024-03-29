package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiMergeToSelect extends ActionVisitorTemplateMerge<StoreInfo, StoreInfo> {
	
	public StoreVisiMergeToSelect(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StoreInfo>> getVisitorClassHook() {
		return StoreVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StoreInfo> mergeHook(List<StoreInfo> baseInfos, List<StoreInfo> selectedInfos) {	
		return StoreMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}	
}
