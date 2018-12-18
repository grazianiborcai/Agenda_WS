package br.com.gda.business.feeStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyFeeStoreSelect extends ActionLazyTemplate<FeeStoreInfo, FeeStoreInfo> {

	public LazyFeeStoreSelect(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FeeStoreInfo> translateRecordInfosHook(List<FeeStoreInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<FeeStoreInfo> getInstanceOfActionHook(DeciTreeOption<FeeStoreInfo> option) {
		return new StdFeeStoreSelect(option);
	}
	
	
	
	@Override protected DeciResult<FeeStoreInfo> translateResultHook(DeciResult<FeeStoreInfo> result) {
		return result;
	}
}
