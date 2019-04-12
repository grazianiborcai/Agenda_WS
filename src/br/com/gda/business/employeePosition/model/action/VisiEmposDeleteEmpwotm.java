package br.com.gda.business.employeePosition.model.action;

import java.sql.Connection;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.employeeWorkTime.model.decisionTree.RootEmpwotmDeleteByEmpos;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiEmposDeleteEmpwotm extends ActionVisitorTemplateAction<EmposInfo, EmpwotmInfo> {
	public VisiEmposDeleteEmpwotm(Connection conn, String schemaName) {
		super(conn, schemaName, EmposInfo.class, EmpwotmInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmpwotmInfo> getActionHook(DeciTreeOption<EmpwotmInfo> option) {
		return new RootEmpwotmDeleteByEmpos(option).toAction();
	}
}
