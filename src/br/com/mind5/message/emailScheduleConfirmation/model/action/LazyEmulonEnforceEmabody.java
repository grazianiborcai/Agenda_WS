package br.com.mind5.message.emailScheduleConfirmation.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.message.emailScheduleConfirmation.info.EmulonInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmulonEnforceEmabody extends ActionLazyTemplateV2<EmulonInfo, EmulonInfo> {

	public LazyEmulonEnforceEmabody(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmulonInfo> translateRecordInfosHook(List<EmulonInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<EmulonInfo> getInstanceOfActionHook(DeciTreeOption<EmulonInfo> option) {
		return new StdEmulonEnforceEmabody(option);
	}
	
	
	
	@Override protected DeciResult<EmulonInfo> translateResultHook(DeciResult<EmulonInfo> result) {
		return result;
	}
}
