package br.com.gda.business.orderSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.orderSearch.info.OrdarchInfo;
import br.com.gda.business.orderSearch.model.decisionTree.RootOrdarchSelect;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyOrdarchRootSelect extends ActionLazyTemplate<OrdarchInfo, OrdarchInfo> {

	public LazyOrdarchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrdarchInfo> translateRecordInfosHook(List<OrdarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OrdarchInfo> getInstanceOfActionHook(DeciTreeOption<OrdarchInfo> option) {
		return new RootOrdarchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<OrdarchInfo> translateResultHook(DeciResult<OrdarchInfo> result) {
		return result;
	}
}
