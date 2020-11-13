package br.com.mind5.business.storeSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.business.storeSearch.model.decisionTree.RootSotarchSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazySotarchRootSelect extends ActionLazyTemplate<SotarchInfo, SotarchInfo> {

	public LazySotarchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<SotarchInfo> translateRecordInfosHook(List<SotarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV1<SotarchInfo> getInstanceOfActionHook(DeciTreeOption<SotarchInfo> option) {
		return new RootSotarchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<SotarchInfo> translateResultHook(DeciResult<SotarchInfo> result) {
		return result;
	}
}
