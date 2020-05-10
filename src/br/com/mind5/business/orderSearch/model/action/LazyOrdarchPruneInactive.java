package br.com.mind5.business.orderSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOrdarchPruneInactive extends ActionLazyTemplateV2<OrdarchInfo, OrdarchInfo> {
	
	public LazyOrdarchPruneInactive(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrdarchInfo> translateRecordInfosHook(List<OrdarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<OrdarchInfo> getInstanceOfActionHook(DeciTreeOption<OrdarchInfo> option) {
		return new StdOrdarchPruneInactive(option);
	}
	
	
	
	@Override protected DeciResult<OrdarchInfo> translateResultHook(DeciResult<OrdarchInfo> result) {
		return result;
	}
}