package br.com.mind5.business.storeWorkTimeRange.model.action;

import java.util.List;

import br.com.mind5.business.storeWorkTimeRange.info.StoworgInfo;
import br.com.mind5.business.storeWorkTimeRange.info.StoworgMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoworgVisiMergeToSelect extends ActionVisitorTemplateMerge<StoworgInfo, StoworgInfo> {
	
	public StoworgVisiMergeToSelect(DeciTreeOption<StoworgInfo> option) {
		super(option, StoworgInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StoworgInfo>> getVisitorClassHook() {
		return StoworgVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StoworgInfo> mergeHook(List<StoworgInfo> baseInfos, List<StoworgInfo> selectedInfos) {	
		return StoworgMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
