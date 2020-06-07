package br.com.mind5.business.employeePosition.model.action;

import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.info.EmposMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmposMergeToSelect extends ActionVisitorTemplateMergeV2<EmposInfo, EmposInfo> {
	
	public VisiEmposMergeToSelect(DeciTreeOption<EmposInfo> option) {
		super(option, EmposInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<EmposInfo>> getActionClassHook() {
		return StdEmposDaoSelect.class;
	}
	
	
	
	@Override protected List<EmposInfo> mergeHook(List<EmposInfo> baseInfos, List<EmposInfo> selectedInfos) {	
		return EmposMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}	
}
