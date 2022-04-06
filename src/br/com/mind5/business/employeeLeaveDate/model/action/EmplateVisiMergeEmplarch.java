package br.com.mind5.business.employeeLeaveDate.model.action;

import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.info.EmplateMerger;
import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.business.employeeLeaveDateSearch.model.decisionTree.EmplarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplateVisiMergeEmplarch extends ActionVisitorTemplateMerge<EmplateInfo, EmplarchInfo> {
	
	public EmplateVisiMergeEmplarch(DeciTreeOption<EmplateInfo> option) {
		super(option, EmplarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplarchInfo>> getTreeClassHook() {
		return EmplarchRootSelect.class;
	}
	
	
	
	@Override protected List<EmplateInfo> mergeHook(List<EmplateInfo> baseInfos, List<EmplarchInfo> selectedInfos) {	
		return EmplateMerger.mergeWithEmplarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
