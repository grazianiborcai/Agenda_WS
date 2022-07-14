package br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info.StusorylirchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info.StusorylirchMerger;

public final class StusorylirchVisiMergeToSelect extends ActionVisitorTemplateMerge<StusorylirchInfo, StusorylirchInfo> {
	
	public StusorylirchVisiMergeToSelect(DeciTreeOption<StusorylirchInfo> option) {
		super(option, StusorylirchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StusorylirchInfo>> getVisitorClassHook() {
		return StusorylirchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StusorylirchInfo> mergeHook(List<StusorylirchInfo> baseInfos, List<StusorylirchInfo> selectedInfos) {	
		return StusorylirchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
