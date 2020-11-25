package br.com.mind5.business.orderItemSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderItemSearch.model.decisionTree.RootOrdemarchSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyOrdemarchRootSelect extends ActionLazyTemplate<OrdemarchInfo, OrdemarchInfo> {

	public LazyOrdemarchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<OrdemarchInfo> translateRecordInfosHook(List<OrdemarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<OrdemarchInfo> getInstanceOfActionHook(DeciTreeOption<OrdemarchInfo> option) {
		return new RootOrdemarchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<OrdemarchInfo> translateResultHook(DeciResult<OrdemarchInfo> result) {
		return result;
	}
}
