package br.com.mind5.business.scheduleWeek.model.action;

import java.util.List;

import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.business.calendarWeekYear.model.decisionTree.CaleekyRootSelectPrevious;
import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeek.info.SchedeekMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedeekVisiMergePrevious extends ActionVisitorTemplateMerge<SchedeekInfo, CaleekyInfo> {
	
	public SchedeekVisiMergePrevious(DeciTreeOption<SchedeekInfo> option) {
		super(option, CaleekyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CaleekyInfo>> getTreeClassHook() {
		return CaleekyRootSelectPrevious.class;
	}
	
	
	
	@Override protected List<SchedeekInfo> mergeHook(List<SchedeekInfo> baseInfos, List<CaleekyInfo> selectedInfos) {	
		return SchedeekMerger.mergeWithCaleeky(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
