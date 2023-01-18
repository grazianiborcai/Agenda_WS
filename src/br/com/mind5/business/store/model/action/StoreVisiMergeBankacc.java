package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.model.decisionTree.BankaccRootSearchStore;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiMergeBankacc extends ActionVisitorTemplateMerge<StoreInfo, BankaccInfo> {
	
	public StoreVisiMergeBankacc(DeciTreeOption<StoreInfo> option) {
		super(option, BankaccInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BankaccInfo>> getTreeClassHook() {
		return BankaccRootSearchStore.class;
	}
	
	
	
	@Override protected List<StoreInfo> mergeHook(List<StoreInfo> baseInfos, List<BankaccInfo> selectedInfos) {	
		return StoreMerger.mergeWithBankacc(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
