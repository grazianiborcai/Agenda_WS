package br.com.mind5.business.orderItemSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapMerger;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.decisionTree.RootWeekdaySelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiOrdemrapMergeWeekday extends ActionVisitorTemplateMerge<OrdemrapInfo, WeekdayInfo> {
	
	public VisiOrdemrapMergeWeekday(DeciTreeOption<OrdemrapInfo> option) {
		super(option, WeekdayInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<WeekdayInfo>> getTreeClassHook() {
		return RootWeekdaySelect.class;
	}
	
	
	
	@Override protected List<OrdemrapInfo> mergeHook(List<OrdemrapInfo> baseInfos, List<WeekdayInfo> selectedInfos) {	
		return OrdemrapMerger.mergeWithWeekday(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
