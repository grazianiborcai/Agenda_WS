package br.com.gda.business.cart.model.decisionTree;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.info.CartMerger;
import br.com.gda.business.masterData.info.CartCategInfo;
import br.com.gda.business.masterData.model.decisionTree.RootCartCategSelect;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class HandlerCartMergeCateg extends ActionLazyTemplate<CartInfo, CartCategInfo> {
	private List<CartInfo> originalInfos;
	
	
	public HandlerCartMergeCateg(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CartCategInfo> translateRecordInfosHook(List<CartInfo> recordInfos) {
		originalInfos = recordInfos;
		return CartCategInfo.copyFrom(recordInfos);
	}
	
	
	
	@Override protected ActionStd<CartCategInfo> getInstanceOfActionHook(DeciTreeOption<CartCategInfo> option) {
		return new RootCartCategSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CartInfo> translateResultHook(DeciResult<CartCategInfo> result) {
		DeciResultHelper<CartInfo> resultHelper = new DeciResultHelper<>();
		resultHelper.copyWithoutResultset(result);
		
		if (result.hasResultset()) {
			resultHelper.resultset = new CartMerger().merge(result.getResultset(), originalInfos);
		
		} else {		
			List<CartInfo> dummy = new ArrayList<>();
			dummy.add(new CartInfo());		
			resultHelper.resultset = dummy;
		}
		
		return resultHelper;
	}
}
