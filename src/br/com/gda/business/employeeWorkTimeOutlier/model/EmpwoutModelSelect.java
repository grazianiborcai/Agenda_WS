package br.com.gda.business.employeeWorkTimeOutlier.model;

import br.com.gda.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.gda.business.employeeWorkTimeOutlier.model.decisionTree.RootEmpwoutSelect;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpwoutModelSelect extends ModelTemplate<EmpwoutInfo> {

	public EmpwoutModelSelect(EmpwoutInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<EmpwoutInfo> getDecisionTreeHook(DeciTreeOption<EmpwoutInfo> option) {
		return new RootEmpwoutSelect(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
