package br.com.mind5.business.employeeLeaveDateSearch.model.action;

import java.util.List;

import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmplarchMergeToSelect extends ActionVisitorTemplateMergeV2<EmplarchInfo, EmplarchInfo> {
	
	public VisiEmplarchMergeToSelect(DeciTreeOption<EmplarchInfo> option) {
		super(option, EmplarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<EmplarchInfo>> getActionClassHook() {
		return StdEmplarchDaoSelect.class;
	}
	
	
	
	@Override protected List<EmplarchInfo> mergeHook(List<EmplarchInfo> baseInfos, List<EmplarchInfo> selectedInfos) {	
		return EmplarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
