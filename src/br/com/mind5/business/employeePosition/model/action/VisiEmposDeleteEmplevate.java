package br.com.mind5.business.employeePosition.model.action;

import java.sql.Connection;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.business.employeeLeaveDate.model.decisionTree.RootEmplateDeleteByEmpos;
import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmposDeleteEmplevate extends ActionVisitorTemplateAction<EmposInfo, EmplateInfo> {
	public VisiEmposDeleteEmplevate(Connection conn, String schemaName) {
		super(conn, schemaName, EmposInfo.class, EmplateInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmplateInfo> getActionHook(DeciTreeOption<EmplateInfo> option) {
		return new RootEmplateDeleteByEmpos(option).toAction();
	}
}
