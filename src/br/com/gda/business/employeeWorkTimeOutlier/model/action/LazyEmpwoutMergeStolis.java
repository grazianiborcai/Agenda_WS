package br.com.gda.business.employeeWorkTimeOutlier.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyEmpwoutMergeStolis extends ActionLazyTemplate<EmpwoutInfo, EmpwoutInfo> {
	
	public LazyEmpwoutMergeStolis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmpwoutInfo> translateRecordInfosHook(List<EmpwoutInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<EmpwoutInfo> getInstanceOfActionHook(DeciTreeOption<EmpwoutInfo> option) {
		return new StdEmpwoutMergeStolis(option);
	}
	
	
	
	@Override protected DeciResult<EmpwoutInfo> translateResultHook(DeciResult<EmpwoutInfo> result) {
		return result;
	}
}
