package br.com.mind5.business.bankAccount.model.action;

import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.info.BankaccMerger;
import br.com.mind5.business.bankAccountSearch.info.BankaccarchInfo;
import br.com.mind5.business.bankAccountSearch.model.decisionTree.BankaccarchRootSelectStore;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccVisiMergeBankaccarchStore extends ActionVisitorTemplateMerge<BankaccInfo, BankaccarchInfo> {
	
	public BankaccVisiMergeBankaccarchStore(DeciTreeOption<BankaccInfo> option) {
		super(option, BankaccarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BankaccarchInfo>> getTreeClassHook() {
		return BankaccarchRootSelectStore.class;
	}
	
	
	
	@Override protected List<BankaccInfo> mergeHook(List<BankaccInfo> baseInfos, List<BankaccarchInfo> selectedInfos) {	
		return BankaccMerger.mergeWithBankaccarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
