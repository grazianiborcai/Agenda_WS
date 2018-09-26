package br.com.gda.business.cart.model.decisionTree;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.info.CartMerger;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.masterData.model.decisionTree.RootWeekdaySelect;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandlerTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciResultHelper;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class HandlerCartMergeWeekday extends DeciActionHandlerTemplate<CartInfo, WeekdayInfo> {
	private List<CartInfo> originalInfos;
	
	
	public HandlerCartMergeWeekday(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<WeekdayInfo> translateRecordInfosHook(List<CartInfo> recordInfos) {
		originalInfos = recordInfos;
		return WeekdayInfo.copyFrom(recordInfos);
	}
	
	
	
	@Override protected DeciAction<WeekdayInfo> getInstanceOfActionHook(DeciTreeOption<WeekdayInfo> option) {
		return new RootWeekdaySelect(option).toAction();
	}
	
	
	
	@Override protected DeciResult<CartInfo> translateResultHook(DeciResult<WeekdayInfo> result) {
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
