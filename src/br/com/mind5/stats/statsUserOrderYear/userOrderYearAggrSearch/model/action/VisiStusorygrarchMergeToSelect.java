package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchMerger;

final class VisiStusorygrarchMergeToSelect extends ActionVisitorTemplateMerge<StusorygrarchInfo, StusorygrarchInfo> {
	
	public VisiStusorygrarchMergeToSelect(DeciTreeOption<StusorygrarchInfo> option) {
		super(option, StusorygrarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StusorygrarchInfo>> getActionClassHook() {
		return StdStusorygrarchDaoSelect.class;
	}
	
	
	
	@Override protected List<StusorygrarchInfo> mergeHook(List<StusorygrarchInfo> baseInfos, List<StusorygrarchInfo> selectedInfos) {	
		return StusorygrarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
