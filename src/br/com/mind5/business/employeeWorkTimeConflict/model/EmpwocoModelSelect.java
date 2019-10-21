package br.com.mind5.business.employeeWorkTimeConflict.model;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.business.employeeWorkTimeConflict.model.decisionTree.RootEmpwocoSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
