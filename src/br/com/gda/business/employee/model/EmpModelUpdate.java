package br.com.gda.business.employee.model;

import javax.servlet.http.HttpServletRequest;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.decisionTree.RootEmpUpdate;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpModelUpdate extends ModelTemplate<EmpInfo> {

	public EmpModelUpdate(String incomingData, HttpServletRequest request) {
		super(incomingData, request, EmpInfo.class);
	}
	
	
	
	@Override protected DeciTree<EmpInfo> getDecisionTreeHook(DeciTreeOption<EmpInfo> option) {
		return new RootEmpUpdate(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
