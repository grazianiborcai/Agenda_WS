package br.com.gda.business.employeeWorkTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.employeeWorkTime.info.EmpwotmMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.username.info.UsernameCopier;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.model.decisionTree.RootUsernameSelect;

final class VisiEmpwotmMergeUsername extends ActionVisitorTemplateMerge<EmpwotmInfo, UsernameInfo> {
	
	public VisiEmpwotmMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<EmpwotmInfo> recordInfos) {
		return UsernameCopier.copyFromEmpwotm(recordInfos);	
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<EmpwotmInfo>> getMergerClassHook() {
		return EmpwotmMerger.class;
	}
}
