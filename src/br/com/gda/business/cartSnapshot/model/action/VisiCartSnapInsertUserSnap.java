package br.com.gda.business.cartSnapshot.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.business.userSnapshot.model.decisionTree.RootUserSnapInsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiCartSnapInsertUserSnap extends ActionVisitorTemplateAction<CartSnapInfo, UserSnapInfo> {
	public VisiCartSnapInsertUserSnap(Connection conn, String schemaName) {
		super(conn, schemaName, CartSnapInfo.class, UserSnapInfo.class);
	}
	
	
	
	@Override protected List<UserSnapInfo> toActionClassHook(List<CartSnapInfo> recordInfos) {
		List<UserSnapInfo> results = new ArrayList<>();
		
		for (CartSnapInfo eachRecord : recordInfos) {
			results.add(UserSnapInfo.copyFrom(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<UserSnapInfo> getActionHook(DeciTreeOption<UserSnapInfo> option) {
		return new RootUserSnapInsert(option).toAction();
	}
	
	
	
	@Override protected List<CartSnapInfo> toBaseClassHook(List<CartSnapInfo> baseInfos, List<UserSnapInfo> results) {
		return baseInfos;
	}
}
