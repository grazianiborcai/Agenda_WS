package br.com.mind5.business.employeePosition.model.action;

import java.sql.Connection;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.decisionTree.RootEmpwotmDeleteByEmpos_;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmposDeleteEmpwotm_ extends ActionVisitorTemplateAction<EmposInfo, EmpwotmInfo> {
	public VisiEmposDeleteEmpwotm_(Connection conn, String schemaName) {
		super(conn, schemaName, EmposInfo.class, EmpwotmInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmpwotmInfo> getActionHook(DeciTreeOption<EmpwotmInfo> option) {
		return new RootEmpwotmDeleteByEmpos_(option).toAction();
	}
}
