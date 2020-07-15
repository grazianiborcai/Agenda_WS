package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSearch.info.UserarchCopier;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.decisionTree.RootUserarchSelectUsername;

final class VisiEmpMergeUserarch extends ActionVisitorTemplateMergeV2<EmpInfo, UserarchInfo> {
	
	public VisiEmpMergeUserarch(DeciTreeOption<EmpInfo> option) {
		super(option, UserarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserarchInfo>> getTreeClassHook() {
		return RootUserarchSelectUsername.class;
	}
	
	
	
	@Override protected List<UserarchInfo> toActionClassHook(List<EmpInfo> baseInfos) {
		return UserarchCopier.copyFromEmp(baseInfos);	
	}
	
	
	
	@Override protected List<EmpInfo> mergeHook(List<EmpInfo> baseInfos, List<UserarchInfo> selectedInfos) {	
		return EmpMerger.mergeWithUserarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
