package br.com.mind5.business.employeeList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmplisMergeFimist extends ActionLazyTemplateV2<EmplisInfo, EmplisInfo> {
	
	public LazyEmplisMergeFimist(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmplisInfo> translateRecordInfosHook(List<EmplisInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<EmplisInfo> getInstanceOfActionHook(DeciTreeOption<EmplisInfo> option) {
		return new StdEmplisMergeFimist(option);
	}
	
	
	
	@Override protected DeciResult<EmplisInfo> translateResultHook(DeciResult<EmplisInfo> result) {
		return result;
	}
}
