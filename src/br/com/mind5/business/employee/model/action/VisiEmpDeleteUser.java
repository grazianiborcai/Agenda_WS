package br.com.mind5.business.employee.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserCopier;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.RootUserDelete;

final class VisiEmpDeleteUser extends ActionVisitorTemplateAction<EmpInfo, UserInfo> {
	public VisiEmpDeleteUser(Connection conn, String schemaName) {
		super(conn, schemaName, EmpInfo.class, UserInfo.class);
	}
	
	
	
	@Override protected List<UserInfo> toActionClassHook(List<EmpInfo> recordInfos) {
		return UserCopier.copyFromEmpKey(recordInfos);
	}
	
	
	
	@Override protected ActionStdV1<UserInfo> getActionHook(DeciTreeOption<UserInfo> option) {
		return new RootUserDelete(option).toAction();
	}
}
