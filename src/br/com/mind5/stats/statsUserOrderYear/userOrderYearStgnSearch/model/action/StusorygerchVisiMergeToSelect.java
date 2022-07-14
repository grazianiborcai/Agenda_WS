package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info.StusorygerchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info.StusorygerchMerger;

public final class StusorygerchVisiMergeToSelect extends ActionVisitorTemplateMerge<StusorygerchInfo, StusorygerchInfo> {
	
	public StusorygerchVisiMergeToSelect(DeciTreeOption<StusorygerchInfo> option) {
		super(option, StusorygerchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StusorygerchInfo>> getVisitorClassHook() {
		return StusorygerchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StusorygerchInfo> mergeHook(List<StusorygerchInfo> baseInfos, List<StusorygerchInfo> selectedInfos) {	
		return StusorygerchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
