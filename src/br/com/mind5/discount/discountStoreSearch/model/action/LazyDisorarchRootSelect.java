package br.com.mind5.discount.discountStoreSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.discount.discountStoreSearch.info.DisorarchInfo;
import br.com.mind5.discount.discountStoreSearch.model.decisionTree.RootDisorarchSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyDisorarchRootSelect extends ActionLazyTemplate<DisorarchInfo, DisorarchInfo> {
	
	public LazyDisorarchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<DisorarchInfo> translateRecordInfosHook(List<DisorarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<DisorarchInfo> getInstanceOfActionHook(DeciTreeOption<DisorarchInfo> option) {
		return new RootDisorarchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<DisorarchInfo> translateResultHook(DeciResult<DisorarchInfo> result) {
		return result;
	}
}
