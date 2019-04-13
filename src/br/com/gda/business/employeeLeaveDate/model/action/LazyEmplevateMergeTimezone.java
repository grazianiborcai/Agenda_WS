package br.com.gda.business.employeeLeaveDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyEmplevateMergeTimezone extends ActionLazyTemplate<EmplevateInfo, EmplevateInfo> {
	
	public LazyEmplevateMergeTimezone(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmplevateInfo> translateRecordInfosHook(List<EmplevateInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<EmplevateInfo> getInstanceOfActionHook(DeciTreeOption<EmplevateInfo> option) {
		return new StdEmplevateMergeTimezone(option);
	}
	
	
	
	@Override protected DeciResult<EmplevateInfo> translateResultHook(DeciResult<EmplevateInfo> result) {
		return result;
	}
}
