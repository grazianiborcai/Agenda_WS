package br.com.mind5.business.calendarMonth.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.info.CalonthMerger;
import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.month.model.decisionTree.MonthRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalonthVisiMergeMonth extends ActionVisitorTemplateMerge<CalonthInfo, MonthInfo> {
	
	public CalonthVisiMergeMonth(DeciTreeOption<CalonthInfo> option) {
		super(option, MonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MonthInfo>> getTreeClassHook() {
		return MonthRootSelect.class;
	}
	
	
	
	@Override protected List<CalonthInfo> mergeHook(List<CalonthInfo> baseInfos, List<MonthInfo> selectedInfos) {	
		return CalonthMerger.mergeWithMonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
