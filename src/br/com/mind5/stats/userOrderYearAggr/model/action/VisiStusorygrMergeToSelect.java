package br.com.mind5.stats.userOrderYearAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userOrderYearAggr.info.StusorygrInfo;
import br.com.mind5.stats.userOrderYearAggr.info.StusorygrMerger;

final class VisiStusorygrMergeToSelect extends ActionVisitorTemplateMerge<StusorygrInfo, StusorygrInfo> {
	
	public VisiStusorygrMergeToSelect(DeciTreeOption<StusorygrInfo> option) {
		super(option, StusorygrInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StusorygrInfo>> getActionClassHook() {
		return StdStusorygrDaoSelect.class;
	}
	
	
	
	@Override protected List<StusorygrInfo> mergeHook(List<StusorygrInfo> baseInfos, List<StusorygrInfo> selectedInfos) {	
		return StusorygrMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
