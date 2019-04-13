package br.com.gda.business.employeePosition.model.action;

import java.sql.Connection;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.business.employeeLeaveDate.model.decisionTree.RootEmplevateDeleteByEmpos;
import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiEmposDeleteEmplevate extends ActionVisitorTemplateAction<EmposInfo, EmplevateInfo> {
	public VisiEmposDeleteEmplevate(Connection conn, String schemaName) {
		super(conn, schemaName, EmposInfo.class, EmplevateInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmplevateInfo> getActionHook(DeciTreeOption<EmplevateInfo> option) {
		return new RootEmplevateDeleteByEmpos(option).toAction();
	}
}
