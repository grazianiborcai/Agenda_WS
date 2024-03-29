package br.com.mind5.business.planningTime.model.action;

import java.util.List;

import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.planningTime.info.PlanimeMerger;
import br.com.mind5.masterData.dayParting.info.DaypartCopier;
import br.com.mind5.masterData.dayParting.info.DaypartInfo;
import br.com.mind5.masterData.dayParting.model.decisionTree.DaypartRootSelect;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PlanimeVisiMergeDaypart extends ActionVisitorTemplateMerge<PlanimeInfo, DaypartInfo> {
	
	public PlanimeVisiMergeDaypart(DeciTreeOption<PlanimeInfo> option) {
		super(option, DaypartInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<DaypartInfo>> getTreeClassHook() {
		return DaypartRootSelect.class;
	}
	
	
	
	@Override protected List<DaypartInfo> toActionClassHook(List<PlanimeInfo> recordInfos) {
		return DaypartCopier.copyFromPlanime(recordInfos);	
	}
	
	
	
	@Override protected List<PlanimeInfo> mergeHook(List<PlanimeInfo> baseInfos, List<DaypartInfo> selectedInfos) {	
		return PlanimeMerger.mergeWithDaypart(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
