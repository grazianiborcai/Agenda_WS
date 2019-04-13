package br.com.gda.business.employeeLeaveDate.model.action;

import java.sql.Connection;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.business.employeeLeaveDate.info.EmplevateMerger;
import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.business.masterData.model.decisionTree.RootTimezoneSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmplevateMergeTimezone extends ActionVisitorTemplateMerge<EmplevateInfo, TimezoneInfo> {
	
	public VisiEmplevateMergeTimezone(Connection conn, String schemaName) {
		super(conn, schemaName, TimezoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<TimezoneInfo>> getTreeClassHook() {
		return RootTimezoneSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<EmplevateInfo>> getMergerClassHook() {
		return EmplevateMerger.class;
	}
}
