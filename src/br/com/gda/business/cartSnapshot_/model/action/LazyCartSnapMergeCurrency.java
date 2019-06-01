package br.com.gda.business.cartSnapshot_.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.cartSnapshot_.info.CartSnapInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyCartSnapMergeCurrency extends ActionLazyTemplate<CartSnapInfo, CartSnapInfo> {
	
	public LazyCartSnapMergeCurrency(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CartSnapInfo> translateRecordInfosHook(List<CartSnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CartSnapInfo> getInstanceOfActionHook(DeciTreeOption<CartSnapInfo> option) {
		return new StdCartSnapMergeCurrency(option);
	}
	
	
	
	@Override protected DeciResult<CartSnapInfo> translateResultHook(DeciResult<CartSnapInfo> result) {		
		return result;
	}
}
