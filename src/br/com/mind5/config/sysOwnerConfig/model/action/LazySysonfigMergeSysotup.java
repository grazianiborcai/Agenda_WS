package br.com.mind5.config.sysOwnerConfig.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.config.sysOwnerConfig.info.SysonfigInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySysonfigMergeSysotup extends ActionLazyTemplate<SysonfigInfo, SysonfigInfo> {

	public LazySysonfigMergeSysotup(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SysonfigInfo> translateRecordInfosHook(List<SysonfigInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SysonfigInfo> getInstanceOfActionHook(DeciTreeOption<SysonfigInfo> option) {
		return new StdSysonfigMergeSysotup(option);
	}
	
	
	
	@Override protected DeciResult<SysonfigInfo> translateResultHook(DeciResult<SysonfigInfo> result) {
		return result;
	}
}
