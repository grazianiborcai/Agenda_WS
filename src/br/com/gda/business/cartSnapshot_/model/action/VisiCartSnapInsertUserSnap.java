package br.com.gda.business.cartSnapshot_.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartSnapshot_.info.CartSnapInfo;
import br.com.gda.business.userSnapshot.info.UserapInfo;
import br.com.gda.business.userSnapshot.model.decisionTree.RootUserapInsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiCartSnapInsertUserSnap extends ActionVisitorTemplateAction<CartSnapInfo, UserapInfo> {
	public VisiCartSnapInsertUserSnap(Connection conn, String schemaName) {
		super(conn, schemaName, CartSnapInfo.class, UserapInfo.class);
	}
	
	
	
	@Override protected List<UserapInfo> toActionClassHook(List<CartSnapInfo> recordInfos) {
		List<UserapInfo> results = new ArrayList<>();
		
		for (CartSnapInfo eachRecord : recordInfos) {
			results.add(UserapInfo.copyFrom(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<UserapInfo> getActionHook(DeciTreeOption<UserapInfo> option) {
		return new RootUserapInsert(option).toAction();
	}
	
	
	
	@Override protected List<CartSnapInfo> toBaseClassHook(List<CartSnapInfo> baseInfos, List<UserapInfo> results) {
		return baseInfos;
	}
}
