package br.com.mind5.business.bankAccountSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.bankAccountSnapshot.info.BankaccnapInfo;
import br.com.mind5.business.bankAccountSnapshot.info.BankaccnapMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccnapVisiMergeToSelect extends ActionVisitorTemplateMerge<BankaccnapInfo, BankaccnapInfo> {
	
	public BankaccnapVisiMergeToSelect(DeciTreeOption<BankaccnapInfo> option) {
		super(option, BankaccnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<BankaccnapInfo>> getVisitorClassHook() {
		return BankaccnapVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<BankaccnapInfo> toActionClassHook(List<BankaccnapInfo> baseInfos) {
		return baseInfos;	
	}	
	
	
	
	@Override protected List<BankaccnapInfo> mergeHook(List<BankaccnapInfo> baseInfos, List<BankaccnapInfo> selectedInfos) {	
		return BankaccnapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
