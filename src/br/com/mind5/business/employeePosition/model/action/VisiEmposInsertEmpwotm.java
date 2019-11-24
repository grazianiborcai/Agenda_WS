package br.com.mind5.business.employeePosition.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.model.decisionTree.RootEmpwotmInsertDefault;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmposInsertEmpwotm extends ActionVisitorTemplateAction<EmposInfo, EmpwotmInfo> {
	public VisiEmposInsertEmpwotm(Connection conn, String schemaName) {
		super(conn, schemaName, EmposInfo.class, EmpwotmInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmpwotmInfo> getActionHook(DeciTreeOption<EmpwotmInfo> option) {
		return new RootEmpwotmInsertDefault(option).toAction();
	}
	
	
	
	@Override protected List<EmposInfo> toBaseClassHook(List<EmposInfo> baseInfos, List<EmpwotmInfo> results) {
		return baseInfos;
	}
}
