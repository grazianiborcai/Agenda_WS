package br.com.mind5.business.scheduleWeek.model.action;

import java.util.List;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeek.info.SchedeekMerger;
import br.com.mind5.masterData.month.info.MonthCopier;
import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.month.model.decisionTree.RootMonthSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedeekMergeMonth extends ActionVisitorTemplateMergeV2<SchedeekInfo, MonthInfo> {
	
	public VisiSchedeekMergeMonth(DeciTreeOption<SchedeekInfo> option) {
		super(option, MonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MonthInfo>> getTreeClassHook() {
		return RootMonthSelect.class;
	}
	
	
	
	@Override protected List<MonthInfo> toActionClassHook(List<SchedeekInfo> recordInfos) {
		return MonthCopier.copyFromSchedeek(recordInfos);
	}
	
	
	
	@Override protected List<SchedeekInfo> mergeHook(List<SchedeekInfo> baseInfos, List<MonthInfo> selectedInfos) {	
		return SchedeekMerger.mergeWithMonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
