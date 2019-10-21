package br.com.mind5.business.employeeLeaveDate.model;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.business.employeeLeaveDate.model.decisionTree.RootEmplevateDelete;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplevateModelDelete extends ModelTemplate<EmplevateInfo> {

	public EmplevateModelDelete(EmplevateInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<EmplevateInfo> getDecisionTreeHook(DeciTreeOption<EmplevateInfo> option) {
		return new RootEmplevateDelete(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
