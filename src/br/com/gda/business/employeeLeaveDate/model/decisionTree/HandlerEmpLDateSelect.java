package br.com.gda.business.employeeLeaveDate.model.decisionTree;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class HandlerEmpLDateSelect extends ActionLazyTemplate<EmpLDateInfo, EmpLDateInfo> {
	
	public HandlerEmpLDateSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmpLDateInfo> translateRecordInfosHook(List<EmpLDateInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<EmpLDateInfo> getInstanceOfActionHook(DeciTreeOption<EmpLDateInfo> option) {
		return new ActionEmpLDateSelect(option);
	}
	
	
	
	@Override protected DeciResult<EmpLDateInfo> translateResultHook(DeciResult<EmpLDateInfo> result) {
		return result;
	}
}
