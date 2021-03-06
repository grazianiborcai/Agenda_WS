package br.com.mind5.discount.discountStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.discount.discountStore.model.decisionTree.RootDisoreInsert;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyDisoreRootInsert extends ActionLazyTemplate<DisoreInfo, DisoreInfo> {
	
	public LazyDisoreRootInsert(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<DisoreInfo> translateRecordInfosHook(List<DisoreInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<DisoreInfo> getInstanceOfActionHook(DeciTreeOption<DisoreInfo> option) {
		return new RootDisoreInsert(option).toAction();
	}
	
	
	
	@Override protected DeciResult<DisoreInfo> translateResultHook(DeciResult<DisoreInfo> result) {
		return result;
	}
}
