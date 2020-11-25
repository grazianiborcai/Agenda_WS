package br.com.mind5.business.orderItemList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOrdemistMergeOrdist extends ActionLazyTemplate<OrdemistInfo, OrdemistInfo> {

	public LazyOrdemistMergeOrdist(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrdemistInfo> translateRecordInfosHook(List<OrdemistInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OrdemistInfo> getInstanceOfActionHook(DeciTreeOption<OrdemistInfo> option) {
		return new StdOrdemistMergeOrdist(option);
	}
	
	
	
	@Override protected DeciResult<OrdemistInfo> translateResultHook(DeciResult<OrdemistInfo> result) {
		return result;
	}
}
