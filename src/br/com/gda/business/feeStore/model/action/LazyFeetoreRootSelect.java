package br.com.gda.business.feeStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.feeStore.info.FeetoreInfo;
import br.com.gda.business.feeStore.model.decisionTree.RootFeetoreSelect;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyFeetoreRootSelect extends ActionLazyTemplate<FeetoreInfo, FeetoreInfo> {

	public LazyFeetoreRootSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FeetoreInfo> translateRecordInfosHook(List<FeetoreInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<FeetoreInfo> getInstanceOfActionHook(DeciTreeOption<FeetoreInfo> option) {
		return new RootFeetoreSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<FeetoreInfo> translateResultHook(DeciResult<FeetoreInfo> result) {
		return result;
	}
}
