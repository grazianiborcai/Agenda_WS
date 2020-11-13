package br.com.mind5.security.userList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.model.decisionTree.NodeUselisPerson;

public final class LazyUselisNodePerson extends ActionLazyTemplate<UselisInfo, UselisInfo> {
	
	public LazyUselisNodePerson(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<UselisInfo> translateRecordInfosHook(List<UselisInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<UselisInfo> getInstanceOfActionHook(DeciTreeOption<UselisInfo> option) {
		return new NodeUselisPerson(option).toAction();
	}
	
	
	
	@Override protected DeciResult<UselisInfo> translateResultHook(DeciResult<UselisInfo> result) {
		return result;
	}
}
