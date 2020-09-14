package br.com.mind5.business.storeFavoriteSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeFavoriteSearch.info.StoritarchInfo;
import br.com.mind5.business.storeFavoriteSearch.info.StoritarchMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoritarchMergeToSelect extends ActionVisitorTemplateMergeV2<StoritarchInfo, StoritarchInfo> {
	
	public VisiStoritarchMergeToSelect(DeciTreeOption<StoritarchInfo> option) {
		super(option, StoritarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<StoritarchInfo>> getActionClassHook() {
		return StdStoritarchDaoSelect.class;
	}
	
	
	
	@Override protected List<StoritarchInfo> mergeHook(List<StoritarchInfo> baseInfos, List<StoritarchInfo> selectedInfos) {	
		return StoritarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
