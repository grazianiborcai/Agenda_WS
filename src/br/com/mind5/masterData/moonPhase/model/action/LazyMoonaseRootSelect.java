package br.com.mind5.masterData.moonPhase.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.moonPhase.model.decisionTree.RootMoonaseSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMoonaseRootSelect extends ActionLazyTemplate<MoonaseInfo, MoonaseInfo> {

	public LazyMoonaseRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MoonaseInfo> translateRecordInfosHook(List<MoonaseInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<MoonaseInfo> getInstanceOfActionHook(DeciTreeOption<MoonaseInfo> option) {
		return new RootMoonaseSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<MoonaseInfo> translateResultHook(DeciResult<MoonaseInfo> result) {
		return result;
	}
}
