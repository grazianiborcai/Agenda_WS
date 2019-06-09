package br.com.gda.message.emailBody.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.message.emailBody.info.EmabodyInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyEmabodyEnforceBody extends ActionLazyTemplate<EmabodyInfo, EmabodyInfo> {

	public LazyEmabodyEnforceBody(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmabodyInfo> translateRecordInfosHook(List<EmabodyInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<EmabodyInfo> getInstanceOfActionHook(DeciTreeOption<EmabodyInfo> option) {
		return new StdEmabodyEnforceBody(option);
	}
	
	
	
	@Override protected DeciResult<EmabodyInfo> translateResultHook(DeciResult<EmabodyInfo> result) {
		return result;
	}
}
