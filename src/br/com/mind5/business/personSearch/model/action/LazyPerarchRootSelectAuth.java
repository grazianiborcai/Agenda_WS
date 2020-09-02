package br.com.mind5.business.personSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.decisionTree.RootPerarchSelectAuth;
import br.com.mind5.model.action.ActionLazyTemplateV2;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPerarchRootSelectAuth extends ActionLazyTemplateV2<PerarchInfo, PerarchInfo> {

	public LazyPerarchRootSelectAuth(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PerarchInfo> translateRecordInfosHook(List<PerarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<PerarchInfo> getInstanceOfActionHook(DeciTreeOption<PerarchInfo> option) {
		return new RootPerarchSelectAuth(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PerarchInfo> translateResultHook(DeciResult<PerarchInfo> result) {
		return result;
	}
}