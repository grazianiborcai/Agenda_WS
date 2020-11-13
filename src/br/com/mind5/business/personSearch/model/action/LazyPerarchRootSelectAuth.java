package br.com.mind5.business.personSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.decisionTree.RootPerarchSelectAuth;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPerarchRootSelectAuth extends ActionLazyTemplate<PerarchInfo, PerarchInfo> {

	public LazyPerarchRootSelectAuth(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PerarchInfo> translateRecordInfosHook(List<PerarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<PerarchInfo> getInstanceOfActionHook(DeciTreeOption<PerarchInfo> option) {
		return new RootPerarchSelectAuth(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PerarchInfo> translateResultHook(DeciResult<PerarchInfo> result) {
		return result;
	}
}
