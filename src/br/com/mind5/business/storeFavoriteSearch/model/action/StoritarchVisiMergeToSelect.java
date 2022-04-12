package br.com.mind5.business.storeFavoriteSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeFavoriteSearch.info.StoritarchInfo;
import br.com.mind5.business.storeFavoriteSearch.info.StoritarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoritarchVisiMergeToSelect extends ActionVisitorTemplateMerge<StoritarchInfo, StoritarchInfo> {
	
	public StoritarchVisiMergeToSelect(DeciTreeOption<StoritarchInfo> option) {
		super(option, StoritarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StoritarchInfo>> getVisitorClassHook() {
		return StoritarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StoritarchInfo> mergeHook(List<StoritarchInfo> baseInfos, List<StoritarchInfo> selectedInfos) {	
		return StoritarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
