package br.com.mind5.business.scheduleYear.model.action;

import java.util.List;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYear.info.SchedyearMerger;
import br.com.mind5.masterData.monthSearch.info.MontharchCopier;
import br.com.mind5.masterData.monthSearch.info.MontharchInfo;
import br.com.mind5.masterData.monthSearch.model.decisionTree.RootMontharchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedyearVisiMergeMontharch extends ActionVisitorTemplateMerge<SchedyearInfo, MontharchInfo> {
	
	public SchedyearVisiMergeMontharch(DeciTreeOption<SchedyearInfo> option) {
		super(option, MontharchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MontharchInfo>> getTreeClassHook() {
		return RootMontharchSelect.class;
	}
	
	
	
	@Override protected List<MontharchInfo> toActionClassHook(List<SchedyearInfo> recordInfos) {
		return MontharchCopier.copyFromSchedyear(recordInfos);
	}
	
	
	
	@Override protected List<SchedyearInfo> mergeHook(List<SchedyearInfo> baseInfos, List<MontharchInfo> selectedInfos) {	
		return SchedyearMerger.mergeWithMontharch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
