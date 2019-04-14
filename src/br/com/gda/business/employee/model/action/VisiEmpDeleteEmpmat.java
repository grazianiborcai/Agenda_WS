package br.com.gda.business.employee.model.action;

import java.sql.Connection;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.business.employeeMaterial.model.decisionTree.RootEmpmatDeleteByEmp;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiEmpDeleteEmpmat extends ActionVisitorTemplateAction<EmpInfo, EmpmatInfo> {
	public VisiEmpDeleteEmpmat(Connection conn, String schemaName) {
		super(conn, schemaName, EmpInfo.class, EmpmatInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmpmatInfo> getActionHook(DeciTreeOption<EmpmatInfo> option) {
		return new RootEmpmatDeleteByEmp(option).toAction();
	}
}
