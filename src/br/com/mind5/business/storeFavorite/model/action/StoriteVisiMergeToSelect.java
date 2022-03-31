package br.com.mind5.business.storeFavorite.model.action;

import java.util.List;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.info.StoriteMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoriteVisiMergeToSelect extends ActionVisitorTemplateMerge<StoriteInfo, StoriteInfo> {
	
	public StoriteVisiMergeToSelect(DeciTreeOption<StoriteInfo> option) {
		super(option, StoriteInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StoriteInfo>> getVisitorClassHook() {
		return StoriteVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StoriteInfo> mergeHook(List<StoriteInfo> baseInfos, List<StoriteInfo> selectedInfos) {	
		return StoriteMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
