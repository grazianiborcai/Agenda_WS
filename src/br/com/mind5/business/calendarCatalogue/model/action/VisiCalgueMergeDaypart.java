package br.com.mind5.business.calendarCatalogue.model.action;

import java.util.List;

import br.com.mind5.business.calendarCatalogue.info.CalgueInfo;
import br.com.mind5.business.calendarCatalogue.info.CalgueMerger;
import br.com.mind5.masterData.dayParting.info.DaypartCopier;
import br.com.mind5.masterData.dayParting.info.DaypartInfo;
import br.com.mind5.masterData.dayParting.model.decisionTree.RootDaypartSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalgueMergeDaypart extends ActionVisitorTemplateMergeV2<CalgueInfo, DaypartInfo> {
	
	public VisiCalgueMergeDaypart(DeciTreeOption<CalgueInfo> option) {
		super(option, DaypartInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<DaypartInfo>> getTreeClassHook() {
		return RootDaypartSelect.class;
	}
	
	
	
	@Override protected List<CalgueInfo> mergeHook(List<CalgueInfo> baseInfos, List<DaypartInfo> selectedInfos) {
		return CalgueMerger.mergeWithDaypart(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected List<DaypartInfo> toActionClassHook(List<CalgueInfo> baseInfos) {
		return DaypartCopier.copyFromCalgue(baseInfos);	
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
