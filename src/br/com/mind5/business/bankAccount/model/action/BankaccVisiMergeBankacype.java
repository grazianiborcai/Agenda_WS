package br.com.mind5.business.bankAccount.model.action;

import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.info.BankaccMerger;
import br.com.mind5.masterData.bankAccountType.info.BankacypeInfo;
import br.com.mind5.masterData.bankAccountType.model.decisionTree.BankacypeRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccVisiMergeBankacype extends ActionVisitorTemplateMerge<BankaccInfo, BankacypeInfo> {
	
	public BankaccVisiMergeBankacype(DeciTreeOption<BankaccInfo> option) {
		super(option, BankacypeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BankacypeInfo>> getTreeClassHook() {
		return BankacypeRootSelect.class;
	}
	
	
	
	@Override protected List<BankaccInfo> mergeHook(List<BankaccInfo> baseInfos, List<BankacypeInfo> selectedInfos) {	
		return BankaccMerger.mergeWithBankacype(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
