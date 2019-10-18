package br.com.gda.business.employeeWorkTime.model;

import javax.servlet.http.HttpServletRequest;
import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.employeeWorkTime.model.decisionTree.RootEmpwotmInsert;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpwotmModelInsert extends ModelTemplate<EmpwotmInfo> {

	public EmpwotmModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, EmpwotmInfo.class);
	}
	
	
	
	@Override protected DeciTree<EmpwotmInfo> getDecisionTreeHook(DeciTreeOption<EmpwotmInfo> option) {
		return new RootEmpwotmInsert(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
