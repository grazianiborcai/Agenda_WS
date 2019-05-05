package br.com.gda.business.employeeLeaveDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.business.employeeLeaveDate.info.EmplevateMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.username.info.UsernameCopier;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.model.decisionTree.RootUsernameSelect;

final class VisiEmplevateMergeUsername extends ActionVisitorTemplateMergeV2<EmplevateInfo, UsernameInfo> {
	
	public VisiEmplevateMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<EmplevateInfo> recordInfos) {
		return UsernameCopier.copyFromEmplevate(recordInfos);	
	}
	
	
	
	@Override protected List<EmplevateInfo> mergeHook(List<EmplevateInfo> recordInfos, List<UsernameInfo> selectedInfos) {	
		return EmplevateMerger.mergeWithUsername(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
