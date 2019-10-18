package br.com.gda.business.employeeWorkTime.model;

import javax.servlet.http.HttpServletRequest;
import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.employeeWorkTime.model.decisionTree.RootEmpwotmUpdate;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpwotmModelUpdate extends ModelTemplate<EmpwotmInfo> {

	public EmpwotmModelUpdate(String incomingData, HttpServletRequest request) {
		super(incomingData, request, EmpwotmInfo.class);
	}
	
	
	
	@Override protected DeciTree<EmpwotmInfo> getDecisionTreeHook(DeciTreeOption<EmpwotmInfo> option) {
		return new RootEmpwotmUpdate(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
