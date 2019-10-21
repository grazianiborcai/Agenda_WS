package br.com.mind5.business.employeeWorkTimeOutlier.model;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.business.employeeWorkTimeOutlier.model.decisionTree.RootEmpwoutSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
