package br.com.mind5.config.sysOwnerConfig.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.config.sysOwnerConfig.info.SysonfigInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySysonfigDaoInsert extends ActionLazyTemplate<SysonfigInfo, SysonfigInfo> {

	public LazySysonfigDaoInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SysonfigInfo> translateRecordInfosHook(List<SysonfigInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<SysonfigInfo> getInstanceOfActionHook(DeciTreeOption<SysonfigInfo> option) {
		return new StdSysonfigDaoInsert(option);
	}
	
	
	
	@Override protected DeciResult<SysonfigInfo> translateResultHook(DeciResult<SysonfigInfo> result) {
		return result;
	}
}
