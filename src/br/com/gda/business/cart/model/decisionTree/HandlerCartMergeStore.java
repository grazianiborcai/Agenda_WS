package br.com.gda.business.cart.model.decisionTree;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.info.CartMerger;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.decisionTree.RootStoreSelect;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandlerTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class HandlerCartMergeStore extends DeciActionHandlerTemplate<CartInfo, StoreInfo> {
	private List<CartInfo> originalInfos;
	
	
	public HandlerCartMergeStore(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<StoreInfo> translateRecordInfosHook(List<CartInfo> recordInfos) {
		originalInfos = recordInfos;
		return StoreInfo.copyFrom(recordInfos);
	}
	
	
	
	@Override protected DeciAction<StoreInfo> getInstanceOfActionHook(DeciTreeOption<StoreInfo> option) {
		return new RootStoreSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CartInfo> translateResultHook(DeciResult<StoreInfo> result) {
		DeciResultHelper<CartInfo> resultHelper = new DeciResultHelper<>();
		resultHelper.copyWithoutResultset(result);
		
		if (result.hasResultset()) {
			resultHelper.resultset = new CartMerger().write(result.getResultset(), originalInfos);
		
		} else {		
			List<CartInfo> dummy = new ArrayList<>();
			dummy.add(new CartInfo());		
			resultHelper.resultset = dummy;
		}
		
		return resultHelper;
	}
}
