package br.com.mind5.business.employeeMaterialSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.business.employeeMaterialSearch.model.decisionTree.RootEmpmarchSelect;
import br.com.mind5.model.action.ActionLazyTemplate;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class LazyEmpmarchRootSelect extends ActionLazyTemplate<EmpmarchInfo, EmpmarchInfo> {

	public LazyEmpmarchRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<EmpmarchInfo> translateRecordInfosHook(List<EmpmarchInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<EmpmarchInfo> getInstanceOfActionHook(DeciTreeOption<EmpmarchInfo> option) {
		return new RootEmpmarchSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<EmpmarchInfo> translateResultHook(DeciResult<EmpmarchInfo> result) {
		return result;
	}
}
