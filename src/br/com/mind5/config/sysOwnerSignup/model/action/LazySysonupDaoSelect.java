package br.com.mind5.config.sysOwnerSignup.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.config.sysOwnerSignup.info.SysonupInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySysonupDaoSelect extends ActionLazyTemplateV2<SysonupInfo, SysonupInfo> {

	public LazySysonupDaoSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SysonupInfo> translateRecordInfosHook(List<SysonupInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SysonupInfo> getInstanceOfActionHook(DeciTreeOption<SysonupInfo> option) {
		return new StdSysonupDaoSelect(option);
	}
	
	
	
	@Override protected DeciResult<SysonupInfo> translateResultHook(DeciResult<SysonupInfo> result) {
		return result;
	}
}