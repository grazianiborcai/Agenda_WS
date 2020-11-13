package br.com.mind5.message.emailScheduleCancellation.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.message.emailScheduleCancellation.info.EmulelInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmulelMergeCuslis extends ActionLazyTemplate<EmulelInfo, EmulelInfo> {

	public LazyEmulelMergeCuslis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmulelInfo> translateRecordInfosHook(List<EmulelInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<EmulelInfo> getInstanceOfActionHook(DeciTreeOption<EmulelInfo> option) {
		return new StdEmulelMergeCuslis(option);
	}
	
	
	
	@Override protected DeciResult<EmulelInfo> translateResultHook(DeciResult<EmulelInfo> result) {
		return result;
	}
}
