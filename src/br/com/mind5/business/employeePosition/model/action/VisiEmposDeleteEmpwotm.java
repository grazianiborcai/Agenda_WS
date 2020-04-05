package br.com.mind5.business.employeePosition.model.action;

import java.sql.Connection;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.decisionTree.RootEmpwotmDeleteByEmpos;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateActionV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmposDeleteEmpwotm extends ActionVisitorTemplateActionV1<EmposInfo, EmpwotmInfo> {
	public VisiEmposDeleteEmpwotm(Connection conn, String schemaName) {
		super(conn, schemaName, EmposInfo.class, EmpwotmInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<EmpwotmInfo> getActionHook(DeciTreeOption<EmpwotmInfo> option) {
		return new RootEmpwotmDeleteByEmpos(option).toAction();
	}
}
