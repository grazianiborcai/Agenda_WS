package br.com.mind5.geo.geoCode.model.action;

import java.util.List;

import br.com.mind5.geo.geoCode.info.GeodeInfo;
import br.com.mind5.geo.geoCode.info.GeodeMerger;
import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.masterData.country.model.decisionTree.RootCountrySelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiGeodeMergeCountry extends ActionVisitorTemplateMergeV2<GeodeInfo, CountryInfo> {
	
	public VisiGeodeMergeCountry(DeciTreeOption<GeodeInfo> option) {
		super(option, CountryInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CountryInfo>> getTreeClassHook() {
		return RootCountrySelect.class;
	}
	
	
	
	@Override protected List<GeodeInfo> mergeHook(List<GeodeInfo> baseInfos, List<CountryInfo> selectedInfos) {
		return GeodeMerger.mergeWithCountry(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
