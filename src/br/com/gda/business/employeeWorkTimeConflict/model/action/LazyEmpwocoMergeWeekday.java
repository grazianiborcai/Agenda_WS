package br.com.gda.business.employeeWorkTimeConflict.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyEmpwocoMergeWeekday extends ActionLazyTemplate<EmpwocoInfo, EmpwocoInfo> {
	
	public LazyEmpwocoMergeWeekday(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmpwocoInfo> translateRecordInfosHook(List<EmpwocoInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<EmpwocoInfo> getInstanceOfActionHook(DeciTreeOption<EmpwocoInfo> option) {
		return new StdEmpwocoMergeWeekday(option);
	}
	
	
	
	@Override protected DeciResult<EmpwocoInfo> translateResultHook(DeciResult<EmpwocoInfo> result) {
		return result;
	}
}
