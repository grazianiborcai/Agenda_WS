package br.com.mind5.business.materialSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.decisionTree.RootMatarchSelectAuth;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatarchRootSelectAuth extends ActionLazyTemplateV2<MatarchInfo, MatarchInfo> {
	
	public LazyMatarchRootSelectAuth(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatarchInfo> translateRecordInfosHook(List<MatarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<MatarchInfo> getInstanceOfActionHook(DeciTreeOption<MatarchInfo> option) {
		return new RootMatarchSelectAuth(option).toAction();
	}
	
	
	
	@Override protected DeciResult<MatarchInfo> translateResultHook(DeciResult<MatarchInfo> result) {		
		return result;
	}
}