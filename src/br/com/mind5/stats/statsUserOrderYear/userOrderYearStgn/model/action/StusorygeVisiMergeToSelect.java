package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.info.StusorygeInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.info.StusorygeMerger;

public final class StusorygeVisiMergeToSelect extends ActionVisitorTemplateMerge<StusorygeInfo, StusorygeInfo> {
	
	public StusorygeVisiMergeToSelect(DeciTreeOption<StusorygeInfo> option) {
		super(option, StusorygeInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StusorygeInfo>> getVisitorClassHook() {
		return StusorygeVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StusorygeInfo> mergeHook(List<StusorygeInfo> baseInfos, List<StusorygeInfo> selectedInfos) {	
		return StusorygeMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
