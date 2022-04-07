package br.com.mind5.business.employeeList.model.action;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.info.EmplisMerger;
import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.employeeSearch.model.decisionTree.EmparchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplisVisiMergeEmparch extends ActionVisitorTemplateMerge<EmplisInfo, EmparchInfo> {
	
	public EmplisVisiMergeEmparch(DeciTreeOption<EmplisInfo> option) {
		super(option, EmparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmparchInfo>> getTreeClassHook() {
		return EmparchRootSelect.class;
	}
	
	
	
	@Override protected List<EmplisInfo> mergeHook(List<EmplisInfo> baseInfos, List<EmparchInfo> selectedInfos) {	
		return EmplisMerger.mergeWithEmparch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
