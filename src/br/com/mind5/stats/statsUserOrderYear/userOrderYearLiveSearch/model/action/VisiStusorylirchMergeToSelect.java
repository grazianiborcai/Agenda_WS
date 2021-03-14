package br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info.StusorylirchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info.StusorylirchMerger;

final class VisiStusorylirchMergeToSelect extends ActionVisitorTemplateMerge<StusorylirchInfo, StusorylirchInfo> {
	
	public VisiStusorylirchMergeToSelect(DeciTreeOption<StusorylirchInfo> option) {
		super(option, StusorylirchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StusorylirchInfo>> getActionClassHook() {
		return StdStusorylirchDaoSelect.class;
	}
	
	
	
	@Override protected List<StusorylirchInfo> mergeHook(List<StusorylirchInfo> baseInfos, List<StusorylirchInfo> selectedInfos) {	
		return StusorylirchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
