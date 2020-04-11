package br.com.mind5.message.emailBody.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.message.emailBody.info.EmabodyInfo;
import br.com.mind5.model.action.ActionLazyTemplateV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmabodyEnforceBody extends ActionLazyTemplateV1<EmabodyInfo, EmabodyInfo> {

	public LazyEmabodyEnforceBody(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmabodyInfo> translateRecordInfosHook(List<EmabodyInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<EmabodyInfo> getInstanceOfActionHook(DeciTreeOption<EmabodyInfo> option) {
		return new StdEmabodyEnforceBody(option);
	}
	
	
	
	@Override protected DeciResult<EmabodyInfo> translateResultHook(DeciResult<EmabodyInfo> result) {
		return result;
	}
}
