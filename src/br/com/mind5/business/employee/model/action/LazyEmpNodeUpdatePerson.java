package br.com.mind5.business.employee.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.decisionTree.NodeEmpUpdatePerson;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmpNodeUpdatePerson extends ActionLazyTemplate<EmpInfo, EmpInfo> {

	public LazyEmpNodeUpdatePerson(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmpInfo> translateRecordInfosHook(List<EmpInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<EmpInfo> getInstanceOfActionHook(DeciTreeOption<EmpInfo> option) {
		return new NodeEmpUpdatePerson(option).toAction();
	}
	
	
	
	@Override protected DeciResult<EmpInfo> translateResultHook(DeciResult<EmpInfo> result) {
		return result;
	}
}
