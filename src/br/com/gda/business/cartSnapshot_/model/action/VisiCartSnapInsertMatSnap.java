package br.com.gda.business.cartSnapshot_.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartSnapshot_.info.CartSnapInfo;
import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.business.materialSnapshot.model.decisionTree.RootMatsnapInsert;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiCartSnapInsertMatSnap extends ActionVisitorTemplateAction<CartSnapInfo, MatsnapInfo> {
	public VisiCartSnapInsertMatSnap(Connection conn, String schemaName) {
		super(conn, schemaName, CartSnapInfo.class, MatsnapInfo.class);
	}
	
	
	
	@Override protected List<MatsnapInfo> toActionClassHook(List<CartSnapInfo> recordInfos) {
		List<MatsnapInfo> results = new ArrayList<>();
		
		for (CartSnapInfo eachRecord : recordInfos) {
			results.add(MatsnapInfo.copyFrom(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<MatsnapInfo> getActionHook(DeciTreeOption<MatsnapInfo> option) {
		return new RootMatsnapInsert(option).toAction();
	}
	
	
	
	@Override protected List<CartSnapInfo> toBaseClassHook(List<CartSnapInfo> baseInfos, List<MatsnapInfo> results) {
		return baseInfos;
	}
}
