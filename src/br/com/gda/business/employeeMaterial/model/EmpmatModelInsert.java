package br.com.gda.business.employeeMaterial.model;

import javax.servlet.http.HttpServletRequest;
import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.business.employeeMaterial.model.decisionTree.RootEmpmatInsert;
import br.com.gda.model.ModelTemplate;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpmatModelInsert extends ModelTemplate<EmpmatInfo> {

	public EmpmatModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, EmpmatInfo.class);
	}
	
	
	
	@Override protected DeciTree<EmpmatInfo> getDecisionTreeHook(DeciTreeOption<EmpmatInfo> option) {
		return new RootEmpmatInsert(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
