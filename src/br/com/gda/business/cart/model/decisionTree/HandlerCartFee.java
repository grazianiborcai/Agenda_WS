package br.com.gda.business.cart.model.decisionTree;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.business.feeStore.model.decisionTree.RootFeeStoreSelect;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class HandlerCartFee extends ActionLazyTemplate<CartInfo, FeeStoreInfo> {
	private final char ITEM_CATEG = 'S';
	private final char FEE_CATEG = 'S';
	
	private List<CartInfo> originalInfos;
	
	
	public HandlerCartFee(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<FeeStoreInfo> translateRecordInfosHook(List<CartInfo> recordInfos) {
		originalInfos = recordInfos;
		
		List<FeeStoreInfo> results = new ArrayList<>();
		results.add(FeeStoreInfo.copyFrom(recordInfos.get(0)));
		return enforceFeeCateg(results);
	}
	
	
	
	private List<FeeStoreInfo> enforceFeeCateg(List<FeeStoreInfo> fees) {
		for (FeeStoreInfo eachFee: fees) {
			eachFee.codFeeCateg = FEE_CATEG;
		}
		
		return fees;
	}
	
	
	
	@Override protected ActionStd<FeeStoreInfo> getInstanceOfActionHook(DeciTreeOption<FeeStoreInfo> option) {
		return new RootFeeStoreSelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CartInfo> translateResultHook(DeciResult<FeeStoreInfo> result) {
		DeciResultHelper<CartInfo> resultHelper = new DeciResultHelper<>();
		resultHelper.copyWithoutResultset(result);
		
		if (result.hasResultset()) {
			resultHelper.resultset = new ArrayList<>(originalInfos);
			resultHelper.resultset.addAll(addFees(result.getResultset()));
		}
		
		return resultHelper;
	}
	
	
	
	private List<CartInfo> addFees (List<FeeStoreInfo> fees) {
		List<CartInfo> results = new ArrayList<>();
		
		for (FeeStoreInfo eachFee : fees) {
			CartInfo cartItem = CartInfo.copyFrom(eachFee);
			cartItem.codItemCateg = ITEM_CATEG;
			cartItem.priceUnit = 1;
			cartItem.quantity = 1;
			results.add(cartItem);
		}
		
		return results;
	}
}
