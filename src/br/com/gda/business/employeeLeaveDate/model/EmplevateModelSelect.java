package br.com.gda.business.employeeLeaveDate.model;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.business.employeeLeaveDate.model.decisionTree.RootEmplevateSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
