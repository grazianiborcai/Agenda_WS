package br.com.mind5.business.scheduleWeek.model.action;

import java.util.List;

import br.com.mind5.business.calendarTimeEmployee.info.CalimempCopier;
import br.com.mind5.business.calendarTimeEmployee.info.CalimempInfo;
import br.com.mind5.business.calendarTimeEmployee.model.decisionTree.RootCalimempSelect;
import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeek.info.SchedeekMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedeekVisiMergeCalimemp extends ActionVisitorTemplateMerge<SchedeekInfo, CalimempInfo> {
	
	public SchedeekVisiMergeCalimemp(DeciTreeOption<SchedeekInfo> option) {
		super(option, CalimempInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalimempInfo>> getTreeClassHook() {
		return RootCalimempSelect.class;
	}
	
	
	
	@Override protected List<CalimempInfo> toActionClassHook(List<SchedeekInfo> baseInfos) {
		return CalimempCopier.copyFromSchedeek(baseInfos);	
	}
	
	
	
	@Override protected List<SchedeekInfo> mergeHook(List<SchedeekInfo> baseInfos, List<CalimempInfo> selectedInfos) {	
		return SchedeekMerger.mergeWithCalimemp(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
