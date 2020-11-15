package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.decisionTree.RootEmpwotmInsertFromStore;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpEmpnapInsert extends ActionVisitorTemplateAction<EmpInfo, EmpwotmInfo> {	
	
	public VisiEmpEmpnapInsert(DeciTreeOption<EmpInfo> option) {
		super(option, EmpInfo.class, EmpwotmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmpwotmInfo>> getTreeClassHook() {
		return RootEmpwotmInsertFromStore.class;
	}
	
	
	
	protected List<EmpInfo> toBaseClassHook(List<EmpInfo> baseInfos, List<EmpwotmInfo> results) {
		return baseInfos;
	}
}
