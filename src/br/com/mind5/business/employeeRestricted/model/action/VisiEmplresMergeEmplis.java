package br.com.mind5.business.employeeRestricted.model.action;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.model.decisionTree.EmplisRootSelect;
import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.employeeRestricted.info.EmplresMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmplresMergeEmplis extends ActionVisitorTemplateMerge<EmplresInfo, EmplisInfo> {
	
	public VisiEmplresMergeEmplis(DeciTreeOption<EmplresInfo> option) {
		super(option, EmplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplisInfo>> getTreeClassHook() {
		return EmplisRootSelect.class;
	}
	
	
	
	@Override protected List<EmplresInfo> mergeHook(List<EmplresInfo> baseInfos, List<EmplisInfo> selectedInfos) {	
		return EmplresMerger.mergeWithEmplis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
