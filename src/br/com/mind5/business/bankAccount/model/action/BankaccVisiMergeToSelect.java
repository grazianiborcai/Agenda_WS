package br.com.mind5.business.bankAccount.model.action;

import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.bankAccount.info.BankaccMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccVisiMergeToSelect extends ActionVisitorTemplateMerge<BankaccInfo, BankaccInfo> {
	
	public BankaccVisiMergeToSelect(DeciTreeOption<BankaccInfo> option) {
		super(option, BankaccInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<BankaccInfo>> getVisitorClassHook() {
		return BankaccVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<BankaccInfo> toActionClassHook(List<BankaccInfo> baseInfos) {
		return baseInfos;	
	}	
	
	
	
	@Override protected List<BankaccInfo> mergeHook(List<BankaccInfo> baseInfos, List<BankaccInfo> selectedInfos) {	
		return BankaccMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
