package br.com.mind5.business.employee.model;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.decisionTree.EmpRootActivate;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpModelActivate extends ModelTemplate<EmpInfo> {

	public EmpModelActivate(EmpInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<EmpInfo> getDecisionTreeHook(DeciTreeOption<EmpInfo> option) {
		return new EmpRootActivate(option);
	}
}
