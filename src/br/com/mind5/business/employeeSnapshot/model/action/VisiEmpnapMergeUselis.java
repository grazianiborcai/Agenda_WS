package br.com.mind5.business.employeeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.employeeSnapshot.info.EmpnapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userList.info.UselisCopier;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.model.decisionTree.UselisRootSelect;

public final class VisiEmpnapMergeUselis extends ActionVisitorTemplateMerge<EmpnapInfo, UselisInfo> {
	
	public VisiEmpnapMergeUselis(DeciTreeOption<EmpnapInfo> option) {
		super(option, UselisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UselisInfo>> getTreeClassHook() {
		return UselisRootSelect.class;
	}
	
	
	
	@Override protected List<UselisInfo> toActionClassHook(List<EmpnapInfo> baseInfos) {
		return UselisCopier.copyFromEmpnap(baseInfos);
	}
	
	
	
	@Override protected List<EmpnapInfo> mergeHook(List<EmpnapInfo> baseInfos, List<UselisInfo> selectedInfos) {	
		return EmpnapMerger.mergeWithUselis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
