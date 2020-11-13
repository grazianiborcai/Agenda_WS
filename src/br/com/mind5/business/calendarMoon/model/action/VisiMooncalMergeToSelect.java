package br.com.mind5.business.calendarMoon.model.action;

import java.util.List;

import br.com.mind5.business.calendarMoon.info.MooncalInfo;
import br.com.mind5.business.calendarMoon.info.MooncalMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMooncalMergeToSelect extends ActionVisitorTemplateMerge<MooncalInfo, MooncalInfo> {
	
	public VisiMooncalMergeToSelect(DeciTreeOption<MooncalInfo> option) {
		super(option, MooncalInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<MooncalInfo>> getActionClassHook() {
		return StdMooncalDaoSelect.class;
	}
	
	
	
	@Override protected List<MooncalInfo> mergeHook(List<MooncalInfo> baseInfos, List<MooncalInfo> selectedInfos) {	
		return MooncalMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
