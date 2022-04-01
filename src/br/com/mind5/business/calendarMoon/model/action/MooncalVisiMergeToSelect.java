package br.com.mind5.business.calendarMoon.model.action;

import java.util.List;

import br.com.mind5.business.calendarMoon.info.MooncalInfo;
import br.com.mind5.business.calendarMoon.info.MooncalMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MooncalVisiMergeToSelect extends ActionVisitorTemplateMerge<MooncalInfo, MooncalInfo> {
	
	public MooncalVisiMergeToSelect(DeciTreeOption<MooncalInfo> option) {
		super(option, MooncalInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<MooncalInfo>> getVisitorClassHook() {
		return MooncalVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<MooncalInfo> mergeHook(List<MooncalInfo> baseInfos, List<MooncalInfo> selectedInfos) {	
		return MooncalMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
