package br.com.mind5.discount.discountStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyDisoreDaoInsert extends ActionLazyTemplate<DisoreInfo, DisoreInfo> {
	
	public LazyDisoreDaoInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<DisoreInfo> translateRecordInfosHook(List<DisoreInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<DisoreInfo> getInstanceOfActionHook(DeciTreeOption<DisoreInfo> option) {
		return new StdDisoreDaoInsert(option);
	}
	
	
	
	@Override protected DeciResult<DisoreInfo> translateResultHook(DeciResult<DisoreInfo> result) {
		return result;
	}
}
