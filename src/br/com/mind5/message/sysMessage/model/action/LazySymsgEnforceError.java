package br.com.mind5.message.sysMessage.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySymsgEnforceError extends ActionLazyTemplateV1<SymsgInfo, SymsgInfo> {

	public LazySymsgEnforceError(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SymsgInfo> translateRecordInfosHook(List<SymsgInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SymsgInfo> getInstanceOfActionHook(DeciTreeOption<SymsgInfo> option) {
		return new StdSymsgEnforceError(option);
	}
	
	
	
	@Override protected DeciResult<SymsgInfo> translateResultHook(DeciResult<SymsgInfo> result) {
		return result;
	}
}
