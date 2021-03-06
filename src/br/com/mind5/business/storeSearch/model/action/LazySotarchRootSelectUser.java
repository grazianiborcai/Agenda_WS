package br.com.mind5.business.storeSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.business.storeSearch.model.decisionTree.RootSotarchSelectUser;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySotarchRootSelectUser extends ActionLazyTemplate<SotarchInfo, SotarchInfo> {

	public LazySotarchRootSelectUser(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SotarchInfo> translateRecordInfosHook(List<SotarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<SotarchInfo> getInstanceOfActionHook(DeciTreeOption<SotarchInfo> option) {
		return new RootSotarchSelectUser(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SotarchInfo> translateResultHook(DeciResult<SotarchInfo> result) {
		return result;
	}
}
