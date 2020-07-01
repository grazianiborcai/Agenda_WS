package br.com.mind5.business.storeNearby.model.action;

import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.info.StorbyMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStorbyMergeToSelect extends ActionVisitorTemplateMergeV2<StorbyInfo, StorbyInfo> {
	
	public VisiStorbyMergeToSelect(DeciTreeOption<StorbyInfo> option) {
		super(option, StorbyInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<StorbyInfo>> getActionClassHook() {
		return StdStorbyDaoSelect.class;
	}
	
	
	
	@Override protected List<StorbyInfo> mergeHook(List<StorbyInfo> baseInfos, List<StorbyInfo> selectedInfos) {	
		return StorbyMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
