package br.com.mind5.business.bankAccount.model.action;

import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.info.BankaccMerger;
import br.com.mind5.masterData.bankHolderType.info.BankoldypeInfo;
import br.com.mind5.masterData.bankHolderType.model.decisionTree.BankoldypeRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccVisiMergeBankoldype extends ActionVisitorTemplateMerge<BankaccInfo, BankoldypeInfo> {
	
	public BankaccVisiMergeBankoldype(DeciTreeOption<BankaccInfo> option) {
		super(option, BankoldypeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BankoldypeInfo>> getTreeClassHook() {
		return BankoldypeRootSelect.class;
	}
	
	
	
	@Override protected List<BankaccInfo> mergeHook(List<BankaccInfo> baseInfos, List<BankoldypeInfo> selectedInfos) {	
		return BankaccMerger.mergeWithBankoldype(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
