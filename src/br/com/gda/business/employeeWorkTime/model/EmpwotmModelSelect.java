package br.com.gda.business.employeeWorkTime.model;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.employeeWorkTime.model.decisionTree.RootEmpwotmSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpwotmModelSelect extends ModelTemplate<EmpwotmInfo> {

	public EmpwotmModelSelect(EmpwotmInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<EmpwotmInfo> getDecisionTreeHook(DeciTreeOption<EmpwotmInfo> option) {
		return new RootEmpwotmSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
