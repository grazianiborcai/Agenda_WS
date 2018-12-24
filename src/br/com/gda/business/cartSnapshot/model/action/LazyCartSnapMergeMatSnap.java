package br.com.gda.business.cartSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.model.action.ActionLazyTemplate;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LazyCartSnapMergeMatSnap extends ActionLazyTemplate<CartSnapInfo, CartSnapInfo> {
	
	public LazyCartSnapMergeMatSnap(Connection conn, String schemaName) {
		super(conn, schemaName);
	}
	
	
	
	@Override protected List<CartSnapInfo> translateRecordInfosHook(List<CartSnapInfo> recordInfos) {
		return recordInfos;
	}
	
	
	
	@Override protected ActionStd<CartSnapInfo> getInstanceOfActionHook(DeciTreeOption<CartSnapInfo> option) {
		return new StdCartSnapMergeMatSnap(option);
	}
	
	
	
	@Override protected DeciResult<CartSnapInfo> translateResultHook(DeciResult<CartSnapInfo> result) {		
		return result;
	}
}
