package br.com.mind5.message.emailScheduleCancellation.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.message.emailScheduleCancellation.info.EmulelInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmulelEnforceEmabody extends ActionLazyTemplateV2<EmulelInfo, EmulelInfo> {

	public LazyEmulelEnforceEmabody(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmulelInfo> translateRecordInfosHook(List<EmulelInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<EmulelInfo> getInstanceOfActionHook(DeciTreeOption<EmulelInfo> option) {
		return new StdEmulelEnforceEmabody(option);
	}
	
	
	
	@Override protected DeciResult<EmulelInfo> translateResultHook(DeciResult<EmulelInfo> result) {
		return result;
	}
}