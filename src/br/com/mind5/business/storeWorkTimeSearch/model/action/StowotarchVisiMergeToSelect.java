package br.com.mind5.business.storeWorkTimeSearch.model.action;

import java.util.List;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StowotarchVisiMergeToSelect extends ActionVisitorTemplateMerge<StowotarchInfo, StowotarchInfo> {
	
	public StowotarchVisiMergeToSelect(DeciTreeOption<StowotarchInfo> option) {
		super(option, StowotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StowotarchInfo>> getVisitorClassHook() {
		return StowotarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StowotarchInfo> mergeHook(List<StowotarchInfo> baseInfos, List<StowotarchInfo> selectedInfos) {	
		return StowotarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
