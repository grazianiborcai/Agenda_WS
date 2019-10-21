package br.com.mind5.business.employeeWorkTimeOutlier.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmpwoutMergeWeekday extends ActionLazyTemplate<EmpwoutInfo, EmpwoutInfo> {
	
	public LazyEmpwoutMergeWeekday(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmpwoutInfo> translateRecordInfosHook(List<EmpwoutInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<EmpwoutInfo> getInstanceOfActionHook(DeciTreeOption<EmpwoutInfo> option) {
		return new StdEmpwoutMergeWeekday(option);
	}
	
	
	
	@Override protected DeciResult<EmpwoutInfo> translateResultHook(DeciResult<EmpwoutInfo> result) {
		return result;
	}
}
