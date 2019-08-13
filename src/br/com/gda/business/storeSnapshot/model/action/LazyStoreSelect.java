package br.com.gda.business.storeSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.storeSnapshot.info.StorapInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyStoreSelect extends ActionLazyTemplate<StorapInfo, StorapInfo> {

	public LazyStoreSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StorapInfo> translateRecordInfosHook(List<StorapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected  ActionStd<StorapInfo> getInstanceOfActionHook(DeciTreeOption<StorapInfo> option) {
		return new StdStoreSelect(option);
	}
	
	
	
	@Override protected DeciResult<StorapInfo> translateResultHook(DeciResult<StorapInfo> result) {
		return result;
	}
}
