package br.com.mind5.business.employeeList.model.action;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.info.EmplisMerger;
import br.com.mind5.business.personSearch.info.PerarchCopier;
import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.decisionTree.PerarchRootSelectEmp;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplisVisiMergePerarch extends ActionVisitorTemplateMerge<EmplisInfo, PerarchInfo> {
	
	public EmplisVisiMergePerarch(DeciTreeOption<EmplisInfo> option) {
		super(option, PerarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PerarchInfo>> getTreeClassHook() {
		return PerarchRootSelectEmp.class;
	}
	
	
	
	@Override protected List<PerarchInfo> toActionClassHook(List<EmplisInfo> baseInfos) {
		return PerarchCopier.copyFromEmplis(baseInfos);	
	}
	
	
	
	@Override protected List<EmplisInfo> mergeHook(List<EmplisInfo> baseInfos, List<PerarchInfo> selectedInfos) {	
		return EmplisMerger.mergeWithPerarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
