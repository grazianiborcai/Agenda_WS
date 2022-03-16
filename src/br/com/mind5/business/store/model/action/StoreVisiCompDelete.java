package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.decisionTree.RootCompDelete;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiCompDelete extends ActionVisitorTemplateAction<StoreInfo, CompInfo> {
	
	public StoreVisiCompDelete(DeciTreeOption<StoreInfo> option) {
		super(option, StoreInfo.class, CompInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CompInfo>> getTreeClassHook() {
		return RootCompDelete.class;
	}
	
	
	
	@Override protected List<CompInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		return CompInfo.copyFrom(recordInfos);
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<CompInfo> results) {
		return baseInfos;
	}
}
