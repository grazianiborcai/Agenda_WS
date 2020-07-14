package br.com.mind5.business.employeeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.employeeSnapshot.info.EmpnapMerger;
import br.com.mind5.business.personList.info.PersolisCopier;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personList.model.decisionTree.RootPersolisSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpnapMergePersolis extends ActionVisitorTemplateMergeV2<EmpnapInfo, PersolisInfo> {
	
	public VisiEmpnapMergePersolis(DeciTreeOption<EmpnapInfo> option) {
		super(option, PersolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersolisInfo>> getTreeClassHook() {
		return RootPersolisSelect.class;
	}
	
	
	
	@Override protected List<PersolisInfo> toActionClassHook(List<EmpnapInfo> baseInfos) {
		return PersolisCopier.copyFromEmpnap(baseInfos);
	}
	
	
	
	@Override protected List<EmpnapInfo> mergeHook(List<EmpnapInfo> baseInfos, List<PersolisInfo> selectedInfos) {	
		return EmpnapMerger.mergeWithPersolis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
