package br.com.mind5.business.employeeMaterial.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.decisionTree.NodeEmpmatSytotauhL2;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmpmatNodeSytotauhL2 extends ActionLazyTemplate<EmpmatInfo, EmpmatInfo> {

	public LazyEmpmatNodeSytotauhL2(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmpmatInfo> translateRecordInfosHook(List<EmpmatInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<EmpmatInfo> getInstanceOfActionHook(DeciTreeOption<EmpmatInfo> option) {
		return new NodeEmpmatSytotauhL2(option).toAction();
	}
	
	
	
	@Override protected DeciResult<EmpmatInfo> translateResultHook(DeciResult<EmpmatInfo> result) {
		return result;
	}
}