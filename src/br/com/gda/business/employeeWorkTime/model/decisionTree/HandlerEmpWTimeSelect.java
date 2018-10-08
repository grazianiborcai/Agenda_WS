package br.com.gda.business.employeeWorkTime.model.decisionTree;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class HandlerEmpWTimeSelect extends ActionLazyTemplate<EmpWTimeInfo, EmpWTimeInfo> {
	
	public HandlerEmpWTimeSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmpWTimeInfo> translateRecordInfosHook(List<EmpWTimeInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<EmpWTimeInfo> getInstanceOfActionHook(DeciTreeOption<EmpWTimeInfo> option) {
		return new ActionEmpWTimeSelect(option);
	}
	
	
	
	@Override protected DeciResult<EmpWTimeInfo> translateResultHook(DeciResult<EmpWTimeInfo> result) {
		return result;
	}
}
