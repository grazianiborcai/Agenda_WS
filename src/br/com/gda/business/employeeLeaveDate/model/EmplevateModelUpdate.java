package br.com.gda.business.employeeLeaveDate.model;

import javax.servlet.http.HttpServletRequest;
import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.business.employeeLeaveDate.model.decisionTree.RootEmplevateUpdate;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmplevateModelUpdate extends ModelTemplate<EmplevateInfo> {

	public EmplevateModelUpdate(String incomingData, HttpServletRequest request) {
		super(incomingData, request, EmplevateInfo.class);
	}
	
	
	
	@Override protected DeciTree<EmplevateInfo> getDecisionTreeHook(DeciTreeOption<EmplevateInfo> option) {
		return new RootEmplevateUpdate(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
