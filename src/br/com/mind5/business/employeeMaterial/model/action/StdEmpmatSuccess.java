package br.com.mind5.business.employeeMaterial.model.action;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpmatSuccess extends ActionStdSuccessTemplate<EmpmatInfo> {
	
	public StdEmpmatSuccess(DeciTreeOption<EmpmatInfo> option) {
		super(option);
	}
}
