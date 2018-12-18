package br.com.gda.business.feeStore.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.business.feeDefault.model.decisionTree.RootFeeDefaultSelect;
import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.business.feeStore.info.FeeStoreMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyFeeStoreMergeDefault extends ActionLazyTemplate<FeeStoreInfo, FeeDefaultInfo> {
	private List<FeeStoreInfo> originalInfos;
	
	
	public LazyFeeStoreMergeDefault(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FeeDefaultInfo> translateRecordInfosHook(List<FeeStoreInfo> recordInfos) {
		originalInfos = recordInfos;
		return FeeDefaultInfo.copyFrom(recordInfos);
	}
	
	
	
	@Override protected ActionStd<FeeDefaultInfo> getInstanceOfActionHook(DeciTreeOption<FeeDefaultInfo> option) {
		return new RootFeeDefaultSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<FeeStoreInfo> translateResultHook(DeciResult<FeeDefaultInfo> result) {
		DeciResultHelper<FeeStoreInfo> resultHelper = new DeciResultHelper<>();
		resultHelper.copyWithoutResultset(result);
		
		if (result.hasResultset()) {
			resultHelper.resultset = new FeeStoreMerger().merge(result.getResultset(), originalInfos);
		
		} else {		
			List<FeeStoreInfo> dummy = new ArrayList<>();
			dummy.add(new FeeStoreInfo());		
			resultHelper.resultset = dummy;
		}
		
		return resultHelper;
	}
}
