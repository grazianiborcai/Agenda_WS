package br.com.mind5.message.emailScheduleConfirmation.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.message.emailScheduleConfirmation.info.EmulonInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmulonSendEmail extends ActionLazyTemplate<EmulonInfo, EmulonInfo> {
	
	public LazyEmulonSendEmail(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmulonInfo> translateRecordInfosHook(List<EmulonInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<EmulonInfo> getInstanceOfActionHook(DeciTreeOption<EmulonInfo> option) {
		return new StdEmulonSendEmail(option);
	}
	
	
	
	@Override protected DeciResult<EmulonInfo> translateResultHook(DeciResult<EmulonInfo> result) {
		return result;
	}
}
