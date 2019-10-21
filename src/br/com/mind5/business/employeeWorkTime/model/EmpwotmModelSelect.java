package br.com.mind5.business.employeeWorkTime.model;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.decisionTree.RootEmpwotmSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
