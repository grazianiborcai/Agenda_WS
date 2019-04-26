package br.com.gda.business.employeeWorkTimeConflict.model.action;

import java.sql.Connection;

import br.com.gda.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.gda.business.employeeWorkTimeConflict.info.EmpwocoMerger;
import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.business.masterData.model.decisionTree.RootTimezoneSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmpwocoMergeTimezone extends ActionVisitorTemplateMerge<EmpwocoInfo, TimezoneInfo> {
	
	public VisiEmpwocoMergeTimezone(Connection conn, String schemaName) {
		super(conn, schemaName, TimezoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<TimezoneInfo>> getTreeClassHook() {
		return RootTimezoneSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<EmpwocoInfo>> getMergerClassHook() {
		return EmpwocoMerger.class;
	}
}
