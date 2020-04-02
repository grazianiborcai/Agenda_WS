package br.com.mind5.business.employee.model.action;

import java.sql.Connection;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeePosition.model.decisionTree.RootEmposDeleteByEmp;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpDeleteEmpos extends ActionVisitorTemplateAction<EmpInfo, EmposInfo> {
	public VisiEmpDeleteEmpos(Connection conn, String schemaName) {
		super(conn, schemaName, EmpInfo.class, EmposInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<EmposInfo> getActionHook(DeciTreeOption<EmposInfo> option) {
		return new RootEmposDeleteByEmp(option).toAction();
	}
}
