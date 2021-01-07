package br.com.mind5.config.sysDistrictSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.config.sysDistrictSearch.info.SysdistrInfo;
import br.com.mind5.config.sysDistrictSearch.model.decisionTree.NodeSysdistrSelectFallback;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySysdistrNodeSelectFallback extends ActionLazyTemplate<SysdistrInfo, SysdistrInfo> {

	public LazySysdistrNodeSelectFallback(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SysdistrInfo> translateRecordInfosHook(List<SysdistrInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SysdistrInfo> getInstanceOfActionHook(DeciTreeOption<SysdistrInfo> option) {
		return new NodeSysdistrSelectFallback(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SysdistrInfo> translateResultHook(DeciResult<SysdistrInfo> result) {
		return result;
	}
}
