package br.com.mind5.business.orderListAuth.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderListAuth.info.OrdistauInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOrdistauMergeOrdist extends ActionLazyTemplate<OrdistauInfo, OrdistauInfo> {

	public LazyOrdistauMergeOrdist(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrdistauInfo> translateRecordInfosHook(List<OrdistauInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OrdistauInfo> getInstanceOfActionHook(DeciTreeOption<OrdistauInfo> option) {
		return new StdOrdistauMergeOrdist(option);
	}
	
	
	
	@Override protected DeciResult<OrdistauInfo> translateResultHook(DeciResult<OrdistauInfo> result) {
		return result;
	}
}
