package br.com.mind5.business.personSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.decisionTree.RootPerarchSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyPerarchRootSelect extends ActionLazyTemplate<PerarchInfo, PerarchInfo> {

	public LazyPerarchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<PerarchInfo> translateRecordInfosHook(List<PerarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<PerarchInfo> getInstanceOfActionHook(DeciTreeOption<PerarchInfo> option) {
		return new RootPerarchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<PerarchInfo> translateResultHook(DeciResult<PerarchInfo> result) {
		return result;
	}
}
