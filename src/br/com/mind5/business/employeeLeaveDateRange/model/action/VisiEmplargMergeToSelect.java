package br.com.mind5.business.employeeLeaveDateRange.model.action;

import java.util.List;

import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.business.employeeLeaveDateRange.info.EmplargMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmplargMergeToSelect extends ActionVisitorTemplateMerge<EmplargInfo, EmplargInfo> {
	
	public VisiEmplargMergeToSelect(DeciTreeOption<EmplargInfo> option) {
		super(option, EmplargInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<EmplargInfo>> getActionClassHook() {
		return StdEmplargDaoSelect.class;
	}
	
	
	
	@Override protected List<EmplargInfo> mergeHook(List<EmplargInfo> baseInfos, List<EmplargInfo> selectedInfos) {	
		return EmplargMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
