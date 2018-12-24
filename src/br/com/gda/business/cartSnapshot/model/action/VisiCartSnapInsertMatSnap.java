package br.com.gda.business.cartSnapshot.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.business.materialSnapshot.model.decisionTree.RootMatSnapInsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiCartSnapInsertMatSnap extends ActionVisitorTemplateAction<CartSnapInfo, MatSnapInfo> {
	public VisiCartSnapInsertMatSnap(Connection conn, String schemaName) {
		super(conn, schemaName, CartSnapInfo.class, MatSnapInfo.class);
	}
	
	
	
	@Override protected List<MatSnapInfo> toActionClassHook(List<CartSnapInfo> recordInfos) {
		List<MatSnapInfo> results = new ArrayList<>();
		
		for (CartSnapInfo eachRecord : recordInfos) {
			results.add(MatSnapInfo.copyFrom(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<MatSnapInfo> getActionHook(DeciTreeOption<MatSnapInfo> option) {
		return new RootMatSnapInsert(option).toAction();
	}
	
	
	
	@Override protected List<CartSnapInfo> toBaseClassHook(List<CartSnapInfo> baseInfos, List<MatSnapInfo> results) {
		return baseInfos;
	}
}
