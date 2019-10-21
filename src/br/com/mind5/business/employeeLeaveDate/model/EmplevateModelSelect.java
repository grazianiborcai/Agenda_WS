package br.com.mind5.business.employeeLeaveDate.model;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.business.employeeLeaveDate.model.decisionTree.RootEmplevateSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmplevateModelSelect extends ModelTemplate<EmplevateInfo> {

	public EmplevateModelSelect(EmplevateInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<EmplevateInfo> getDecisionTreeHook(DeciTreeOption<EmplevateInfo> option) {
		return new RootEmplevateSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
