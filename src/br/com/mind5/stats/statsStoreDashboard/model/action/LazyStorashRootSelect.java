package br.com.mind5.stats.statsStoreDashboard.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreDashboard.info.StorashInfo;
import br.com.mind5.stats.statsStoreDashboard.model.decisionTree.RootStorashSelect;

public final class LazyStorashRootSelect extends ActionLazyTemplate<StorashInfo, StorashInfo> {

	public LazyStorashRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StorashInfo> translateRecordInfosHook(List<StorashInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<StorashInfo> getInstanceOfActionHook(DeciTreeOption<StorashInfo> option) {
		return new RootStorashSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<StorashInfo> translateResultHook(DeciResult<StorashInfo> result) {
		return result;
	}
}
