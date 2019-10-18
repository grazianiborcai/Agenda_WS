package br.com.gda.business.employeeLeaveDate.model;

import javax.servlet.http.HttpServletRequest;
import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.business.employeeLeaveDate.model.decisionTree.RootEmplevateInsert;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmplevateModelInsert extends ModelTemplate<EmplevateInfo> {

	public EmplevateModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, EmplevateInfo.class);
	}
	
	
	
	@Override protected DeciTree<EmplevateInfo> getDecisionTreeHook(DeciTreeOption<EmplevateInfo> option) {
		return new RootEmplevateInsert(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
