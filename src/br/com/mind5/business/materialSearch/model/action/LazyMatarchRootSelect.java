package br.com.mind5.business.materialSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.decisionTree.RootMatarchSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyMatarchRootSelect extends ActionLazyTemplate<MatarchInfo, MatarchInfo> {
	
	public LazyMatarchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<MatarchInfo> translateRecordInfosHook(List<MatarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStdV2<MatarchInfo> getInstanceOfActionHook(DeciTreeOption<MatarchInfo> option) {
		return new RootMatarchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<MatarchInfo> translateResultHook(DeciResult<MatarchInfo> result) {		
		return result;
	}
}
