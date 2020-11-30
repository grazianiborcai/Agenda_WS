package br.com.mind5.business.employeeMaterial.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.decisionTree.RootEmpmatInsert;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpmatModelInsert extends ModelTemplate<EmpmatInfo> {

	public EmpmatModelInsert(String incomingData, HttpServletRequest request) {
		super(incomingData, request, EmpmatInfo.class);
	}
	
	
	
	@Override protected DeciTree<EmpmatInfo> getDecisionTreeHook(DeciTreeOption<EmpmatInfo> option) {
		return new RootEmpmatInsert(option);
	}
}
