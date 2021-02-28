package br.com.mind5.stats.userOrderYearLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userOrderYearLive.info.StusoryliInfo;
import br.com.mind5.stats.userOrderYearLive.info.StusoryliMerger;

final class VisiStusoryliMergeToSelect extends ActionVisitorTemplateMerge<StusoryliInfo, StusoryliInfo> {
	
	public VisiStusoryliMergeToSelect(DeciTreeOption<StusoryliInfo> option) {
		super(option, StusoryliInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StusoryliInfo>> getActionClassHook() {
		return StdStusoryliDaoSelect.class;
	}
	
	
	
	@Override protected List<StusoryliInfo> mergeHook(List<StusoryliInfo> baseInfos, List<StusoryliInfo> selectedInfos) {	
		return StusoryliMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
