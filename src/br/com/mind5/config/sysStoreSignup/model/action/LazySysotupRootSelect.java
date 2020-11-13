package br.com.mind5.config.sysStoreSignup.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.config.sysStoreSignup.model.decisionTree.RootSysotupSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySysotupRootSelect extends ActionLazyTemplate<SysotupInfo, SysotupInfo> {

	public LazySysotupRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SysotupInfo> translateRecordInfosHook(List<SysotupInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SysotupInfo> getInstanceOfActionHook(DeciTreeOption<SysotupInfo> option) {
		return new RootSysotupSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SysotupInfo> translateResultHook(DeciResult<SysotupInfo> result) {
		return result;
	}
}
