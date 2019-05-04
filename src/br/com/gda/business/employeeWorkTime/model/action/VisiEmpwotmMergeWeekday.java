package br.com.gda.business.employeeWorkTime.model.action;

import java.sql.Connection;
import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.employeeWorkTime.info.EmpwotmMerger;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.masterData.model.decisionTree.RootWeekdaySelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmpwotmMergeWeekday extends ActionVisitorTemplateMerge_<EmpwotmInfo, WeekdayInfo> {
	
	public VisiEmpwotmMergeWeekday(Connection conn, String schemaName) {
		super(conn, schemaName, WeekdayInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<WeekdayInfo>> getTreeClassHook() {
		return RootWeekdaySelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<EmpwotmInfo>> getMergerClassHook() {
		return EmpwotmMerger.class;
	}
}
