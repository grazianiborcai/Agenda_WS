package br.com.mind5.business.storeFavorite.model.action;

import java.util.List;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.info.StoriteMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoriteMergeToSelect extends ActionVisitorTemplateMergeV2<StoriteInfo, StoriteInfo> {
	
	public VisiStoriteMergeToSelect(DeciTreeOption<StoriteInfo> option) {
		super(option, StoriteInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<StoriteInfo>> getActionClassHook() {
		return StdStoriteDaoSelect.class;
	}
	
	
	
	@Override protected List<StoriteInfo> mergeHook(List<StoriteInfo> baseInfos, List<StoriteInfo> selectedInfos) {	
		return StoriteMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
