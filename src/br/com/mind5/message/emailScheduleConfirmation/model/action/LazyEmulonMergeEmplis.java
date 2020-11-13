package br.com.mind5.message.emailScheduleConfirmation.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.message.emailScheduleConfirmation.info.EmulonInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmulonMergeEmplis extends ActionLazyTemplate<EmulonInfo, EmulonInfo> {

	public LazyEmulonMergeEmplis(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmulonInfo> translateRecordInfosHook(List<EmulonInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<EmulonInfo> getInstanceOfActionHook(DeciTreeOption<EmulonInfo> option) {
		return new StdEmulonMergeEmplis(option);
	}
	
	
	
	@Override protected DeciResult<EmulonInfo> translateResultHook(DeciResult<EmulonInfo> result) {
		return result;
	}
}
