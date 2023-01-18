package br.com.mind5.business.bankAccountSearch.model.action;

import java.util.List;

import br.com.mind5.business.bankAccountSearch.info.BankaccarchInfo;
import br.com.mind5.business.bankAccountSearch.info.BankaccarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankaccarchVisiMergeToSelect extends ActionVisitorTemplateMerge<BankaccarchInfo, BankaccarchInfo> {
	
	public BankaccarchVisiMergeToSelect(DeciTreeOption<BankaccarchInfo> option) {
		super(option, BankaccarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<BankaccarchInfo>> getVisitorClassHook() {
		return BankaccarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<BankaccarchInfo> toActionClassHook(List<BankaccarchInfo> baseInfos) {
		return baseInfos;	
	}	
	
	
	
	@Override protected List<BankaccarchInfo> mergeHook(List<BankaccarchInfo> baseInfos, List<BankaccarchInfo> selectedInfos) {	
		return BankaccarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
