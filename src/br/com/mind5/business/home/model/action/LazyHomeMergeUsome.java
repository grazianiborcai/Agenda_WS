package br.com.mind5.business.home.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.home.info.HomeInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyHomeMergeUsome extends ActionLazyTemplate<HomeInfo, HomeInfo> {

	public LazyHomeMergeUsome(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<HomeInfo> translateRecordInfosHook(List<HomeInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<HomeInfo> getInstanceOfActionHook(DeciTreeOption<HomeInfo> option) {
		return new StdHomeMergeUsome(option);
	}
	
	
	
	@Override protected DeciResult<HomeInfo> translateResultHook(DeciResult<HomeInfo> result) {
		return result;
	}
}
