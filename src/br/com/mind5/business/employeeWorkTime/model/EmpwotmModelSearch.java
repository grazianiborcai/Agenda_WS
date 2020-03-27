package br.com.mind5.business.employeeWorkTime.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.decisionTree.RootEmpwotmSearch;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwotmModelSearch extends ModelTemplate<EmpwotmInfo> {

	public EmpwotmModelSearch(String incomingData, HttpServletRequest request) {
		super(incomingData, request, EmpwotmInfo.class);
	}
	
	
	
	@Override protected DeciTree<EmpwotmInfo> getDecisionTreeHook(DeciTreeOption<EmpwotmInfo> option) {
		return new RootEmpwotmSearch(option);
	}
	
	
	
	@Override protected Class<?> getImplamentationClassHook() {
		return this.getClass();
	}
}
