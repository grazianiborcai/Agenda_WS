package br.com.mind5.message.emailBody.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.message.emailBody.info.EmabodyInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmabodyEnforceBody extends ActionLazyTemplate<EmabodyInfo, EmabodyInfo> {

	public LazyEmabodyEnforceBody(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmabodyInfo> translateRecordInfosHook(List<EmabodyInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<EmabodyInfo> getInstanceOfActionHook(DeciTreeOption<EmabodyInfo> option) {
		return new StdEmabodyEnforceBody(option);
	}
	
	
	
	@Override protected DeciResult<EmabodyInfo> translateResultHook(DeciResult<EmabodyInfo> result) {
		return result;
	}
}
