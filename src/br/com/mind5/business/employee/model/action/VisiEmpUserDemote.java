package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpMerger;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.RootUserDemoteEmp;

final class VisiEmpUserDemote extends ActionVisitorTemplateAction<EmpInfo, UserInfo> {
	
	public VisiEmpUserDemote(DeciTreeOption<EmpInfo> option) {
		super(option, EmpInfo.class, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return RootUserDemoteEmp.class;
	}
	
	
	
	@Override protected List<EmpInfo> toBaseClassHook(List<EmpInfo> baseInfos, List<UserInfo> results) {
		return EmpMerger.mergeWithUser(baseInfos, results);
	}
}
