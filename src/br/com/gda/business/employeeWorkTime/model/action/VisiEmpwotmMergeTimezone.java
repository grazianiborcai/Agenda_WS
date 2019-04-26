package br.com.gda.business.employeeWorkTime.model.action;

import java.sql.Connection;
import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.employeeWorkTime.info.EmpwotmMerger;
import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.business.masterData.model.decisionTree.RootTimezoneSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmpwotmMergeTimezone extends ActionVisitorTemplateMerge<EmpwotmInfo, TimezoneInfo> {
	
	public VisiEmpwotmMergeTimezone(Connection conn, String schemaName) {
		super(conn, schemaName, TimezoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<TimezoneInfo>> getTreeClassHook() {
		return RootTimezoneSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<EmpwotmInfo>> getMergerClassHook() {
		return EmpwotmMerger.class;
	}
}
