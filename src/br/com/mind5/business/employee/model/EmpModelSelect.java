package br.com.mind5.business.employee.model;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.decisionTree.RootEmpSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpModelSelect extends ModelTemplate<EmpInfo> {

	public EmpModelSelect(EmpInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<EmpInfo> getDecisionTreeHook(DeciTreeOption<EmpInfo> option) {
		return new RootEmpSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
