package br.com.mind5.business.store.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.decisionTree.RootCompDelete;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoreDeleteComp extends ActionVisitorTemplateAction<StoreInfo, CompInfo> {
	public VisiStoreDeleteComp(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class, CompInfo.class);
	}
	
	
	
	@Override protected List<CompInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		List<CompInfo> results = new ArrayList<>();
		
		for (StoreInfo eachRecord : recordInfos) {
			results.add(CompInfo.copyFrom(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<CompInfo> getActionHook(DeciTreeOption<CompInfo> option) {
		return new RootCompDelete(option).toAction();
	}
}
