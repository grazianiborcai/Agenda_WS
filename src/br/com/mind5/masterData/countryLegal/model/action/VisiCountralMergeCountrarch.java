package br.com.mind5.masterData.countryLegal.model.action;

import java.util.List;

import br.com.mind5.masterData.countryLegal.info.CountralInfo;
import br.com.mind5.masterData.countryLegal.info.CountralMerger;
import br.com.mind5.masterData.countryLegalSearch.info.CountrarchInfo;
import br.com.mind5.masterData.countryLegalSearch.model.decisionTree.RootCountrarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCountralMergeCountrarch extends ActionVisitorTemplateMergeV2<CountralInfo, CountrarchInfo> {
	
	public VisiCountralMergeCountrarch(DeciTreeOption<CountralInfo> option) {
		super(option, CountrarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CountrarchInfo>> getTreeClassHook() {
		return RootCountrarchSelect.class;
	}
	
	
	
	@Override protected List<CountralInfo> mergeHook(List<CountralInfo> baseInfos, List<CountrarchInfo> selectedInfos) {	
		return CountralMerger.mergeWithCountrarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
