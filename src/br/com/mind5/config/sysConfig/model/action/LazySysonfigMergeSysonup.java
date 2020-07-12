package br.com.mind5.config.sysConfig.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.config.sysConfig.info.SysonfigInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySysonfigMergeSysonup extends ActionLazyTemplateV2<SysonfigInfo, SysonfigInfo> {

	public LazySysonfigMergeSysonup(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SysonfigInfo> translateRecordInfosHook(List<SysonfigInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SysonfigInfo> getInstanceOfActionHook(DeciTreeOption<SysonfigInfo> option) {
		return new StdSysonfigMergeSysonup(option);
	}
	
	
	
	@Override protected DeciResult<SysonfigInfo> translateResultHook(DeciResult<SysonfigInfo> result) {
		return result;
	}
}
