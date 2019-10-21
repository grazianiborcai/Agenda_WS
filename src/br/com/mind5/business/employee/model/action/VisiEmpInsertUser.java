package br.com.mind5.business.employee.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserCopier;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.RootUserInsert;

final class VisiEmpInsertUser extends ActionVisitorTemplateAction<EmpInfo, UserInfo> {
	public VisiEmpInsertUser(Connection conn, String schemaName) {
		super(conn, schemaName, EmpInfo.class, UserInfo.class);
	}
	
	
	
	@Override protected List<UserInfo> toActionClassHook(List<EmpInfo> recordInfos) {
		List<UserInfo> results = new ArrayList<>();
		
		for (EmpInfo eachRecord : recordInfos) {
			results.add(UserCopier.copyFromEmp(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<UserInfo> getActionHook(DeciTreeOption<UserInfo> option) {
		return new RootUserInsert(option).toAction();
	}
	
	
	
	@Override protected List<EmpInfo> toBaseClassHook(List<EmpInfo> baseInfos, List<UserInfo> results) {
		return EmpMerger.mergeWithUser(results, baseInfos);
	}
}
