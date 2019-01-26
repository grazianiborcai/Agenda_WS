package br.com.gda.business.employee.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.decisionTree.NodeEmpUpsertPhone;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyEmpNodeUpsertPhone extends ActionLazyTemplate<EmpInfo, EmpInfo> {

	public LazyEmpNodeUpsertPhone(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmpInfo> translateRecordInfosHook(List<EmpInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected  ActionStd<EmpInfo> getInstanceOfActionHook(DeciTreeOption<EmpInfo> option) {
		return new NodeEmpUpsertPhone(option).toAction();
	}
	
	
	
	@Override protected DeciResult<EmpInfo> translateResultHook(DeciResult<EmpInfo> result) {
		return result;
	}
}
