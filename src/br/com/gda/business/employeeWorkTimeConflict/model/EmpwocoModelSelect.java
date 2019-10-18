package br.com.gda.business.employeeWorkTimeConflict.model;

import br.com.gda.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.gda.business.employeeWorkTimeConflict.model.decisionTree.RootEmpwocoSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpwocoModelSelect extends ModelTemplate<EmpwocoInfo> {

	public EmpwocoModelSelect(EmpwocoInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<EmpwocoInfo> getDecisionTreeHook(DeciTreeOption<EmpwocoInfo> option) {
		return new RootEmpwocoSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
