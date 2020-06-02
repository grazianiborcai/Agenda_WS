package br.com.mind5.business.scheduleWeek.model.action;

import java.util.List;

import br.com.mind5.business.calendarTimeStore.info.CalimoreCopier;
import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.business.calendarTimeStore.model.decisionTree.RootCalimoreSelect;
import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeek.info.SchedeekMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedeekMergeCalimore extends ActionVisitorTemplateMergeV2<SchedeekInfo, CalimoreInfo> {
	
	public VisiSchedeekMergeCalimore(DeciTreeOption<SchedeekInfo> option) {
		super(option, CalimoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalimoreInfo>> getTreeClassHook() {
		return RootCalimoreSelect.class;
	}
	
	
	
	@Override protected List<CalimoreInfo> toActionClassHook(List<SchedeekInfo> baseInfos) {
		return CalimoreCopier.copyFromSchedeek(baseInfos);	
	}
	
	
	
	@Override protected List<SchedeekInfo> mergeHook(List<SchedeekInfo> baseInfos, List<CalimoreInfo> selectedInfos) {	
		return SchedeekMerger.mergeWithCalimore(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
