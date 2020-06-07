package br.com.mind5.business.employeePositionSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.business.employeePositionSearch.info.EmposarchMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmposarchMergeToSelect extends ActionVisitorTemplateMergeV2<EmposarchInfo, EmposarchInfo> {
	
	public VisiEmposarchMergeToSelect(DeciTreeOption<EmposarchInfo> option) {
		super(option, EmposarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<EmposarchInfo>> getActionClassHook() {
		return StdEmposarchDaoSelect.class;
	}
	
	
	
	@Override protected List<EmposarchInfo> mergeHook(List<EmposarchInfo> baseInfos, List<EmposarchInfo> selectedInfos) {	
		return EmposarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}	
}
