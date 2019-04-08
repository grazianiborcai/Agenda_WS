package br.com.gda.business.employee.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.user.info.UserCopier;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.decisionTree.RootUserDelete;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiEmpDeleteUser extends ActionVisitorTemplateAction<EmpInfo, UserInfo> {
	public VisiEmpDeleteUser(Connection conn, String schemaName) {
		super(conn, schemaName, EmpInfo.class, UserInfo.class);
	}
	
	
	
	@Override protected List<UserInfo> toActionClassHook(List<EmpInfo> recordInfos) {
		return UserCopier.copyFromEmpKey(recordInfos);
	}
	
	
	
	@Override protected ActionStd<UserInfo> getActionHook(DeciTreeOption<UserInfo> option) {
		return new RootUserDelete(option).toAction();
	}
}
