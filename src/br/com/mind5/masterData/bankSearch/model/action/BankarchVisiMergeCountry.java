package br.com.mind5.masterData.bankSearch.model.action;

import java.util.List;

import br.com.mind5.masterData.bankSearch.info.BankarchInfo;
import br.com.mind5.masterData.bankSearch.info.BankarchMerger;
import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.masterData.country.model.decisionTree.CountryRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BankarchVisiMergeCountry extends ActionVisitorTemplateMerge<BankarchInfo, CountryInfo> {
	
	public BankarchVisiMergeCountry(DeciTreeOption<BankarchInfo> option) {
		super(option, CountryInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CountryInfo>> getTreeClassHook() {
		return CountryRootSelect.class;
	}
	
	
	
	@Override protected List<BankarchInfo> mergeHook(List<BankarchInfo> baseInfos, List<CountryInfo> selectedInfos) {	
		return BankarchMerger.mergeWithCountry(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
