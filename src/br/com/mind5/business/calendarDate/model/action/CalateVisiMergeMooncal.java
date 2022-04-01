package br.com.mind5.business.calendarDate.model.action;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.info.CalateMerger;
import br.com.mind5.business.calendarMoon.info.MooncalCopier;
import br.com.mind5.business.calendarMoon.info.MooncalInfo;
import br.com.mind5.business.calendarMoon.model.decisionTree.RootMooncalSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalateVisiMergeMooncal extends ActionVisitorTemplateMerge<CalateInfo, MooncalInfo> {
	
	public CalateVisiMergeMooncal(DeciTreeOption<CalateInfo> option) {
		super(option, MooncalInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MooncalInfo>> getTreeClassHook() {
		return RootMooncalSelect.class;
	}
	
	
	
	@Override protected List<MooncalInfo> toActionClassHook(List<CalateInfo> recordInfos) {
		return MooncalCopier.copyFromCalate(recordInfos);
	}
	
	
	
	@Override protected List<CalateInfo> mergeHook(List<CalateInfo> baseInfos, List<MooncalInfo> selectedInfos) {	
		return CalateMerger.mergeWithMooncal(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
