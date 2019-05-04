package br.com.gda.business.employeeWorkTimeConflict.model.action;

import java.sql.Connection;

import br.com.gda.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.gda.business.employeeWorkTimeConflict.info.EmpwocoMerger;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.masterData.model.decisionTree.RootWeekdaySelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmpwocoMergeWeekday extends ActionVisitorTemplateMerge_<EmpwocoInfo, WeekdayInfo> {
	
	public VisiEmpwocoMergeWeekday(Connection conn, String schemaName) {
		super(conn, schemaName, WeekdayInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<WeekdayInfo>> getTreeClassHook() {
		return RootWeekdaySelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<EmpwocoInfo>> getMergerClassHook() {
		return EmpwocoMerger.class;
	}
}
