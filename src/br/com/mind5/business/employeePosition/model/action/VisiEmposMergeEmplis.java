package br.com.mind5.business.employeePosition.model.action;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.model.decisionTree.RootEmplisSelect;
import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.info.EmposMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmposMergeEmplis extends ActionVisitorTemplateMerge<EmposInfo, EmplisInfo> {
	
	public VisiEmposMergeEmplis(DeciTreeOption<EmposInfo> option) {
		super(option, EmplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplisInfo>> getTreeClassHook() {
		return RootEmplisSelect.class;
	}
	
	
	
	@Override protected List<EmposInfo> mergeHook(List<EmposInfo> baseInfos, List<EmplisInfo> selectedInfos) {	
		return EmposMerger.mergeWithEmplis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
