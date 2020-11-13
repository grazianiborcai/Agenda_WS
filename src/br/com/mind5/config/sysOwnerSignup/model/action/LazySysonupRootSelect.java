package br.com.mind5.config.sysOwnerSignup.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.config.sysOwnerSignup.info.SysonupInfo;
import br.com.mind5.config.sysOwnerSignup.model.decisionTree.RootSysonupSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySysonupRootSelect extends ActionLazyTemplate<SysonupInfo, SysonupInfo> {

	public LazySysonupRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SysonupInfo> translateRecordInfosHook(List<SysonupInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SysonupInfo> getInstanceOfActionHook(DeciTreeOption<SysonupInfo> option) {
		return new RootSysonupSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SysonupInfo> translateResultHook(DeciResult<SysonupInfo> result) {
		return result;
	}
}
