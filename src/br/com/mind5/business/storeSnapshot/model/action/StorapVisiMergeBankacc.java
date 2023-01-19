package br.com.mind5.business.storeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.model.decisionTree.BankaccRootSelect;
import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.info.StorapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorapVisiMergeBankacc extends ActionVisitorTemplateMerge<StorapInfo, BankaccInfo> {
	
	public StorapVisiMergeBankacc(DeciTreeOption<StorapInfo> option) {
		super(option, BankaccInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BankaccInfo>> getTreeClassHook() {
		return BankaccRootSelect.class;
	}
	
	
	
	@Override protected List<StorapInfo> mergeHook(List<StorapInfo> baseInfos, List<BankaccInfo> selectedInfos) {	
		return StorapMerger.mergeWithBankacc(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}	
}
