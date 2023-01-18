package br.com.mind5.business.bankAccount.model.action;

import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.info.BankaccMerger;
import br.com.mind5.masterData.bank.info.BankInfo;
import br.com.mind5.masterData.bank.model.decisionTree.BankRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccVisiMergeBank extends ActionVisitorTemplateMerge<BankaccInfo, BankInfo> {
	
	public BankaccVisiMergeBank(DeciTreeOption<BankaccInfo> option) {
		super(option, BankInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BankInfo>> getTreeClassHook() {
		return BankRootSelect.class;
	}
	
	
	
	@Override protected List<BankaccInfo> mergeHook(List<BankaccInfo> baseInfos, List<BankInfo> selectedInfos) {	
		return BankaccMerger.mergeWithBank(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
