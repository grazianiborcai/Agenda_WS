package br.com.mind5.business.employeeList.model.action;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.info.EmplisMerger;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personList.model.decisionTree.RootPersolisSelectRestricted;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmplisMergePersolis extends ActionVisitorTemplateMerge<EmplisInfo, PersolisInfo> {
	
	public VisiEmplisMergePersolis(DeciTreeOption<EmplisInfo> option) {
		super(option, PersolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersolisInfo>> getTreeClassHook() {
		return RootPersolisSelectRestricted.class;
	}
	
	
	
	@Override protected List<EmplisInfo> mergeHook(List<EmplisInfo> baseInfos, List<PersolisInfo> selectedInfos) {	
		return EmplisMerger.mergeWithPersolis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
