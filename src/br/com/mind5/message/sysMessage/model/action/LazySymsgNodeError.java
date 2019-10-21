package br.com.mind5.message.sysMessage.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.model.decisionTree.NodeSymsgError;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySymsgNodeError extends ActionLazyTemplate<SymsgInfo, SymsgInfo> {

	public LazySymsgNodeError(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SymsgInfo> translateRecordInfosHook(List<SymsgInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected  ActionStd<SymsgInfo> getInstanceOfActionHook(DeciTreeOption<SymsgInfo> option) {
		return new NodeSymsgError(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SymsgInfo> translateResultHook(DeciResult<SymsgInfo> result) {
		return result;
	}
}
