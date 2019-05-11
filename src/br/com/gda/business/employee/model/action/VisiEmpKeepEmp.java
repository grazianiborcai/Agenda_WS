package br.com.gda.business.employee.model.action;

import java.sql.Connection;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.info.EmpKeeper;
import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateKeep;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
