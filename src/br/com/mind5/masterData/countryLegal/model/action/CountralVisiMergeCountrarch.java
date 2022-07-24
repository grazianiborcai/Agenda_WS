package br.com.mind5.masterData.countryLegal.model.action;

import java.util.List;

import br.com.mind5.masterData.countryLegal.info.CountralInfo;
import br.com.mind5.masterData.countryLegal.info.CountralMerger;
import br.com.mind5.masterData.countryLegalSearch.info.CountrarchInfo;
import br.com.mind5.masterData.countryLegalSearch.model.decisionTree.CountrarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CountralVisiMergeCountrarch extends ActionVisitorTemplateMerge<CountralInfo, CountrarchInfo> {
	
	public CountralVisiMergeCountrarch(DeciTreeOption<CountralInfo> option) {
		super(option, CountrarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CountrarchInfo>> getTreeClassHook() {
		return CountrarchRootSelect.class;
	}
	
	
	
	@Override protected List<CountralInfo> mergeHook(List<CountralInfo> baseInfos, List<CountrarchInfo> selectedInfos) {	
		return CountralMerger.mergeWithCountrarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
