package br.com.mind5.business.bankAccountSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.bankAccountSnapshot.info.BankaccnapInfo;
import br.com.mind5.business.bankAccountSnapshot.info.BankaccnapMerger;
import br.com.mind5.masterData.bank.info.BankInfo;
import br.com.mind5.masterData.bank.model.decisionTree.BankRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccnapVisiMergeBank extends ActionVisitorTemplateMerge<BankaccnapInfo, BankInfo> {
	
	public BankaccnapVisiMergeBank(DeciTreeOption<BankaccnapInfo> option) {
		super(option, BankInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BankInfo>> getTreeClassHook() {
		return BankRootSelect.class;
	}
	
	
	
	@Override protected List<BankaccnapInfo> mergeHook(List<BankaccnapInfo> baseInfos, List<BankInfo> selectedInfos) {	
		return BankaccnapMerger.mergeWithBank(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
