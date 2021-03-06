package br.com.mind5.config.sysOwnerConfig.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.config.sysOwnerConfig.info.SysonfigInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySysonfigMergeSysdistr extends ActionLazyTemplate<SysonfigInfo, SysonfigInfo> {

	public LazySysonfigMergeSysdistr(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SysonfigInfo> translateRecordInfosHook(List<SysonfigInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SysonfigInfo> getInstanceOfActionHook(DeciTreeOption<SysonfigInfo> option) {
		return new StdSysonfigMergeSysdistr(option);
	}
	
	
	
	@Override protected DeciResult<SysonfigInfo> translateResultHook(DeciResult<SysonfigInfo> result) {
		return result;
	}
}
