package br.com.mind5.business.bankAccountSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.bankAccountSnapshot.info.BankaccnapInfo;
import br.com.mind5.business.bankAccountSnapshot.info.BankaccnapMerger;
import br.com.mind5.masterData.bankHolderType.info.BankoldypeInfo;
import br.com.mind5.masterData.bankHolderType.model.decisionTree.BankoldypeRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccnapVisiMergeBankoldype extends ActionVisitorTemplateMerge<BankaccnapInfo, BankoldypeInfo> {
	
	public BankaccnapVisiMergeBankoldype(DeciTreeOption<BankaccnapInfo> option) {
		super(option, BankoldypeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BankoldypeInfo>> getTreeClassHook() {
		return BankoldypeRootSelect.class;
	}
	
	
	
	@Override protected List<BankaccnapInfo> mergeHook(List<BankaccnapInfo> baseInfos, List<BankoldypeInfo> selectedInfos) {	
		return BankaccnapMerger.mergeWithBankoldype(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
