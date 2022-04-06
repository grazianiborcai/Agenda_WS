package br.com.mind5.business.calendarTimeEmployee.model.action;

import java.util.List;

import br.com.mind5.business.calendarTimeEmployee.info.CalimempInfo;
import br.com.mind5.business.calendarTimeEmployee.info.CalimempMerger;
import br.com.mind5.business.employeeLeaveDateRange.info.EmplargCopier;
import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.business.employeeLeaveDateRange.model.decisionTree.EmplargRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalimempVisiMergeEmplarg extends ActionVisitorTemplateMerge<CalimempInfo, EmplargInfo> {
	
	public CalimempVisiMergeEmplarg(DeciTreeOption<CalimempInfo> option) {
		super(option, EmplargInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplargInfo>> getTreeClassHook() {
		return EmplargRootSelect.class;
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
