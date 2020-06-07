package br.com.mind5.business.calendarTimeEmployee.model.action;

import java.util.List;

import br.com.mind5.business.calendarTimeEmployee.info.CalimempInfo;
import br.com.mind5.business.calendarTimeEmployee.info.CalimempMerger;
import br.com.mind5.business.employeeLeaveDateRange.info.EmplargCopier;
import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.business.employeeLeaveDateRange.model.decisionTree.RootEmplargSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalimempMergeEmplarg extends ActionVisitorTemplateMergeV2<CalimempInfo, EmplargInfo> {
	
	public VisiCalimempMergeEmplarg(DeciTreeOption<CalimempInfo> option) {
		super(option, EmplargInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplargInfo>> getTreeClassHook() {
		return RootEmplargSelect.class;
	}
	
	
	
	@Override protected List<EmplargInfo> toActionClassHook(List<CalimempInfo> baseInfos) {
		return EmplargCopier.copyFromCalimemp(baseInfos);	
	}
	
	
	
	@Override protected List<CalimempInfo> mergeHook(List<CalimempInfo> baseInfos, List<EmplargInfo> selectedInfos) {	
		return CalimempMerger.mergeWithEmplarg(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
