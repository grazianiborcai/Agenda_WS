package br.com.mind5.business.store.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.decisionTree.RootCompDelete;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoreDeleteComp extends ActionVisitorTemplateAction<StoreInfo, CompInfo> {
	public VisiStoreDeleteComp(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class, CompInfo.class);
	}
	
	
	
	@Override protected List<CompInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		return CompInfo.copyFrom(recordInfos);
	}
	
	
	
	@Override protected ActionStdV1<CompInfo> getActionHook(DeciTreeOption<CompInfo> option) {
		return new RootCompDelete(option).toAction();
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<CompInfo> results) {
		return baseInfos;
	}
}
