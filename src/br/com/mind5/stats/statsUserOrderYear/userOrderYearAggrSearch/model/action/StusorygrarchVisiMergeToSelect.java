package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchMerger;

public final class StusorygrarchVisiMergeToSelect extends ActionVisitorTemplateMerge<StusorygrarchInfo, StusorygrarchInfo> {
	
	public StusorygrarchVisiMergeToSelect(DeciTreeOption<StusorygrarchInfo> option) {
		super(option, StusorygrarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StusorygrarchInfo>> getVisitorClassHook() {
		return StusorygrarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StusorygrarchInfo> mergeHook(List<StusorygrarchInfo> baseInfos, List<StusorygrarchInfo> selectedInfos) {	
		return StusorygrarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
