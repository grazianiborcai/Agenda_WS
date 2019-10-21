package br.com.mind5.business.employeePosition.model.action;

import java.sql.Connection;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.business.employeeLeaveDate.model.decisionTree.RootEmplevateDeleteByEmpos;
import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmposDeleteEmplevate extends ActionVisitorTemplateAction<EmposInfo, EmplevateInfo> {
	public VisiEmposDeleteEmplevate(Connection conn, String schemaName) {
		super(conn, schemaName, EmposInfo.class, EmplevateInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmplevateInfo> getActionHook(DeciTreeOption<EmplevateInfo> option) {
		return new RootEmplevateDeleteByEmpos(option).toAction();
	}
}
