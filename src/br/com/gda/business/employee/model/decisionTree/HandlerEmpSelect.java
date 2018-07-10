package br.com.gda.business.employee.model.decisionTree;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandlerTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class HandlerEmpSelect extends DeciActionHandlerTemplate<EmpInfo, EmpInfo> {
	
	public HandlerEmpSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmpInfo> translateRecordInfosHook(List<EmpInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected DeciAction<EmpInfo> getInstanceOfActionHook(DeciTreeOption<EmpInfo> option) {
		return new ActionEmpSelect(option);
	}
	
	
	
	@Override protected DeciResult<EmpInfo> translateResultHook(DeciResult<EmpInfo> result) {
		return result;
	}
}
