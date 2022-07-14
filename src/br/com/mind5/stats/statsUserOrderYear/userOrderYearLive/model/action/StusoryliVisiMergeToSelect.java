package br.com.mind5.stats.statsUserOrderYear.userOrderYearLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLive.info.StusoryliInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLive.info.StusoryliMerger;

public final class StusoryliVisiMergeToSelect extends ActionVisitorTemplateMerge<StusoryliInfo, StusoryliInfo> {
	
	public StusoryliVisiMergeToSelect(DeciTreeOption<StusoryliInfo> option) {
		super(option, StusoryliInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<StusoryliInfo>> getVisitorClassHook() {
		return StusoryliVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<StusoryliInfo> mergeHook(List<StusoryliInfo> baseInfos, List<StusoryliInfo> selectedInfos) {	
		return StusoryliMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
