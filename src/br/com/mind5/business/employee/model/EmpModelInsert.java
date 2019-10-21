package br.com.mind5.business.employee.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.decisionTree.RootEmpInsert;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpModelInsert extends ModelTemplate<EmpInfo> {

	public EmpModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, EmpInfo.class);
	}
	
	
	
	@Override protected DeciTree<EmpInfo> getDecisionTreeHook(DeciTreeOption<EmpInfo> option) {
		return new RootEmpInsert(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
