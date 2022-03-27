package br.com.mind5.business.employeeWorkTimeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeSnapshot.info.EmpwotmapInfo;
import br.com.mind5.business.employeeWorkTimeSnapshot.info.EmpwotmapMerger;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.decisionTree.RootWeekdaySelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwotmapVisiMergeWeekday extends ActionVisitorTemplateMerge<EmpwotmapInfo, WeekdayInfo> {
	
	public EmpwotmapVisiMergeWeekday(DeciTreeOption<EmpwotmapInfo> option) {
		super(option, WeekdayInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<WeekdayInfo>> getTreeClassHook() {
		return RootWeekdaySelect.class;
	}
	
	
	
	@Override protected List<EmpwotmapInfo> mergeHook(List<EmpwotmapInfo> baseInfos, List<WeekdayInfo> selectedInfos) {	
		return EmpwotmapMerger.mergeWithWeekday(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
