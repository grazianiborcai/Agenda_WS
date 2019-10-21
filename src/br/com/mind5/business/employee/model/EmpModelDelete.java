package br.com.mind5.business.employee.model;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.decisionTree.RootEmpDelete;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpModelDelete extends ModelTemplate<EmpInfo> {

	public EmpModelDelete(EmpInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<EmpInfo> getDecisionTreeHook(DeciTreeOption<EmpInfo> option) {
		return new RootEmpDelete(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
