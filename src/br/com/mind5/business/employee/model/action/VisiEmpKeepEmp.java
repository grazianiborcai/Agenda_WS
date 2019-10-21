package br.com.mind5.business.employee.model.action;

import java.sql.Connection;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpKeeper;
import br.com.mind5.info.obsolete.InfoWritterFactory_;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateKeep;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpKeepEmp extends ActionVisitorTemplateKeep<EmpInfo, EmpInfo> {

	public VisiEmpKeepEmp(Connection conn, String schemaName) {
		super(conn, schemaName, EmpInfo.class);
	}
	
	
	
	@Override protected ActionStd<EmpInfo> getActionHook(DeciTreeOption<EmpInfo> option) {
		ActionStd<EmpInfo> actionSelect = new StdEmpEnforceKey(option);
		actionSelect.addPostAction(new LazyEmpRootSelect(option.conn, option.schemaName));
		return actionSelect;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<EmpInfo>> getKeeperClassHook() {
		return EmpKeeper.class;
	}
}
