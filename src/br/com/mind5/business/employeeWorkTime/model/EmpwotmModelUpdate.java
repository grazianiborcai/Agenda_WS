package br.com.mind5.business.employeeWorkTime.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.decisionTree.EmpwotmRootUpdate;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpwotmModelUpdate extends ModelTemplate<EmpwotmInfo> {

	public EmpwotmModelUpdate(String incomingData, HttpServletRequest request) {
		super(incomingData, request, EmpwotmInfo.class);
	}
	
	
	
	@Override protected DeciTree<EmpwotmInfo> getDecisionTreeHook(DeciTreeOption<EmpwotmInfo> option) {
		return new EmpwotmRootUpdate(option);
	}
}
