package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.info.StusorygrInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.info.StusorygrMerger;

public final class StusorygrVisiMergeToSelect extends ActionVisitorTemplateMerge<StusorygrInfo, StusorygrInfo> {
	
	public StusorygrVisiMergeToSelect(DeciTreeOption<StusorygrInfo> option) {
		super(option, StusorygrInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StusorygrInfo>> getVisitorClassHook() {
		return StusorygrVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StusorygrInfo> mergeHook(List<StusorygrInfo> baseInfos, List<StusorygrInfo> selectedInfos) {	
		return StusorygrMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
