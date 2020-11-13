package br.com.mind5.business.storeNearby.model.action;

import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.info.StorbyMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorbyMergeToSelect extends ActionVisitorTemplateMerge<StorbyInfo, StorbyInfo> {
	
	public VisiStorbyMergeToSelect(DeciTreeOption<StorbyInfo> option) {
		super(option, StorbyInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StorbyInfo>> getActionClassHook() {
		return StdStorbyDaoSelect.class;
	}
	
	
	
	@Override protected List<StorbyInfo> mergeHook(List<StorbyInfo> baseInfos, List<StorbyInfo> selectedInfos) {	
		return StorbyMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
