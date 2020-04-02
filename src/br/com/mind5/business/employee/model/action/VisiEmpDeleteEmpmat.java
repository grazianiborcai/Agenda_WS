package br.com.mind5.business.employee.model.action;

import java.sql.Connection;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.decisionTree.RootEmpmatDeleteByEmp;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpDeleteEmpmat extends ActionVisitorTemplateAction<EmpInfo, EmpmatInfo> {
	public VisiEmpDeleteEmpmat(Connection conn, String schemaName) {
		super(conn, schemaName, EmpInfo.class, EmpmatInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<EmpmatInfo> getActionHook(DeciTreeOption<EmpmatInfo> option) {
		return new RootEmpmatDeleteByEmp(option).toAction();
	}
}
