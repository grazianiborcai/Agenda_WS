package br.com.gda.business.employee.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.info.EmpMerger;
import br.com.gda.business.user.info.UserCopier;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.decisionTree.RootUserInsert;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
		InfoWritterFactory<EmpInfo> merger = new EmpMerger();		
		return merger.merge(results, baseInfos);
	}
}
