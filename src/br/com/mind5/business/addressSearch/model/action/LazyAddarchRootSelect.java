package br.com.mind5.business.addressSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSearch.model.decisionTree.RootAddarchSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyAddarchRootSelect extends ActionLazyTemplate<AddarchInfo, AddarchInfo> {

	public LazyAddarchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<AddarchInfo> translateRecordInfosHook(List<AddarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<AddarchInfo> getInstanceOfActionHook(DeciTreeOption<AddarchInfo> option) {
		return new RootAddarchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<AddarchInfo> translateResultHook(DeciResult<AddarchInfo> result) {
		return result;
	}
}
