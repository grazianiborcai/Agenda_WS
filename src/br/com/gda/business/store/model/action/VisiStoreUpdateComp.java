package br.com.gda.business.store.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.company.info.CompCopier;
import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.company.model.decisionTree.RootCompUpdate;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.info.StoreMerger;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiStoreUpdateComp extends ActionVisitorTemplateAction<StoreInfo, CompInfo> {
	public VisiStoreUpdateComp(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class, CompInfo.class);
	}
	
	
	
	@Override protected List<CompInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		List<CompInfo> results = new ArrayList<>();
		
		for (StoreInfo eachRecord : recordInfos) {
			results.add(CompCopier.copyFromStore(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<CompInfo> getActionHook(DeciTreeOption<CompInfo> option) {
		return new RootCompUpdate(option).toAction();
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<CompInfo> results) {
		InfoWritterFactory<StoreInfo> merger = new StoreMerger();		
		return merger.merge(results, baseInfos);
	}
}
