package br.com.mind5.business.employeePositionSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.business.employeePositionSearch.info.EmposarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmposarchMergeToSelect extends ActionVisitorTemplateMerge<EmposarchInfo, EmposarchInfo> {
	
	public VisiEmposarchMergeToSelect(DeciTreeOption<EmposarchInfo> option) {
		super(option, EmposarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmposarchInfo>> getActionClassHook() {
		return StdEmposarchDaoSelect.class;
	}
	
	
	
	@Override protected List<EmposarchInfo> mergeHook(List<EmposarchInfo> baseInfos, List<EmposarchInfo> selectedInfos) {	
		return EmposarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}	
}
