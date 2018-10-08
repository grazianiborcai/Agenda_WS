package br.com.gda.business.cart.model.decisionTree;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.amount.info.AmountInfo;
import br.com.gda.business.amount.model.decisionTree.ActionAmountTotal;
import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class HandlerCartTotal extends ActionLazyTemplate<CartInfo, AmountInfo> {
	private final char ITEM_CATEG = 'T';
	
	private List<CartInfo> originalInfos;
	private CartInfo lineTotal;
	

	public HandlerCartTotal(Connection conn, String schemaName) {
		super(conn, schemaName);
		lineTotal = new CartInfo();
	}
	
	
	
	@Override protected List<AmountInfo> translateRecordInfosHook(List<CartInfo> recordInfos) {
		originalInfos = new ArrayList<>(recordInfos);
		return AmountInfo.copyFrom(recordInfos);
	}
	
	
	
	@Override protected ActionStd<AmountInfo> getInstanceOfActionHook(DeciTreeOption<AmountInfo> option) {
		return new ActionAmountTotal(option);
	}
	
	
	
	@Override protected DeciResult<CartInfo> translateResultHook(DeciResult<AmountInfo> result) {
		DeciResultHelper<CartInfo> resultHelper = new DeciResultHelper<>();		
		resultHelper.copyWithoutResultset(result);
		
		if (result.hasResultset()) {
			resultHelper.resultset = new ArrayList<>(originalInfos);
			
			makeTotal(result.getResultset(), originalInfos);
			resultHelper.resultset.add(lineTotal);
		}
		
		return resultHelper;
	}
	
	
	
	private void makeTotal(List<AmountInfo> totals, List<CartInfo> originals) {
		AmountInfo oneTotal = totals.get(0);		
		lineTotal.price = oneTotal.amount;
		lineTotal.codCurr = oneTotal.codCurr;
		lineTotal = enforceCateg(lineTotal);
		
		
		CartInfo oneCart = originals.get(0);
		lineTotal.codOwner = oneCart.codOwner;
		lineTotal.codCustomer = oneCart.codCustomer;
	}
	
	
	
	private CartInfo enforceCateg(CartInfo totalItem) {
		totalItem.codItemCateg = ITEM_CATEG;
		return totalItem;
	}
}
