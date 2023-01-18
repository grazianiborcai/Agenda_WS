package br.com.mind5.masterData.bank.model.action;

import java.util.List;

import br.com.mind5.masterData.bank.info.BankInfo;
import br.com.mind5.masterData.bank.info.BankMerger;
import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.masterData.country.model.decisionTree.CountryRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankVisiMergeCountry extends ActionVisitorTemplateMerge<BankInfo, CountryInfo> {
	
	public BankVisiMergeCountry(DeciTreeOption<BankInfo> option) {
		super(option, CountryInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CountryInfo>> getTreeClassHook() {
		return CountryRootSelect.class;
	}
	
	
	
	@Override protected List<BankInfo> mergeHook(List<BankInfo> baseInfos, List<CountryInfo> selectedInfos) {	
		return BankMerger.mergeWithCountry(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
