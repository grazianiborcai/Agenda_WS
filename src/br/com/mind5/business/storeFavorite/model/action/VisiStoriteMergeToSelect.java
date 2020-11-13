package br.com.mind5.business.storeFavorite.model.action;

import java.util.List;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.info.StoriteMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoriteMergeToSelect extends ActionVisitorTemplateMerge<StoriteInfo, StoriteInfo> {
	
	public VisiStoriteMergeToSelect(DeciTreeOption<StoriteInfo> option) {
		super(option, StoriteInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StoriteInfo>> getActionClassHook() {
		return StdStoriteDaoSelect.class;
	}
	
	
	
	@Override protected List<StoriteInfo> mergeHook(List<StoriteInfo> baseInfos, List<StoriteInfo> selectedInfos) {	
		return StoriteMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
