package br.com.mind5.business.bankAccountSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.bankAccountSnapshot.info.BankaccnapInfo;
import br.com.mind5.business.bankAccountSnapshot.info.BankaccnapMerger;
import br.com.mind5.masterData.bankAccountType.info.BankacypeInfo;
import br.com.mind5.masterData.bankAccountType.model.decisionTree.BankacypeRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccnapVisiMergeBankacype extends ActionVisitorTemplateMerge<BankaccnapInfo, BankacypeInfo> {
	
	public BankaccnapVisiMergeBankacype(DeciTreeOption<BankaccnapInfo> option) {
		super(option, BankacypeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BankacypeInfo>> getTreeClassHook() {
		return BankacypeRootSelect.class;
	}
	
	
	
	@Override protected List<BankaccnapInfo> mergeHook(List<BankaccnapInfo> baseInfos, List<BankacypeInfo> selectedInfos) {	
		return BankaccnapMerger.mergeWithBankacype(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
