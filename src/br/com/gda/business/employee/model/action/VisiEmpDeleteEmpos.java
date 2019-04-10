package br.com.gda.business.employee.model.action;

import java.sql.Connection;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.employeePosition.model.decisionTree.RootEmposDeleteByEmp;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiEmpDeleteEmpos extends ActionVisitorTemplateAction<EmpInfo, EmposInfo> {
	public VisiEmpDeleteEmpos(Connection conn, String schemaName) {
		super(conn, schemaName, EmpInfo.class, EmposInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmposInfo> getActionHook(DeciTreeOption<EmposInfo> option) {
		return new RootEmposDeleteByEmp(option).toAction();
	}
}
