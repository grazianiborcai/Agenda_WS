package br.com.mind5.message.sysMessage.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.model.decisionTree.NodeSymsgSelectL1;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySymsgNodeSelectL1 extends ActionLazyTemplateV2<SymsgInfo, SymsgInfo> {

	public LazySymsgNodeSelectL1(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SymsgInfo> translateRecordInfosHook(List<SymsgInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SymsgInfo> getInstanceOfActionHook(DeciTreeOption<SymsgInfo> option) {
		return new NodeSymsgSelectL1(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SymsgInfo> translateResultHook(DeciResult<SymsgInfo> result) {
		return result;
	}
}
