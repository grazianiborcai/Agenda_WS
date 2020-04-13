package br.com.mind5.masterData.stateSearch.info;

import java.util.List;

import br.com.mind5.business.masterData.info.CountryInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class StatarchMerger {	
	public static List<StatarchInfo> mergeWithCountry(List<StatarchInfo> baseInfos, List<CountryInfo> selectedInfos) {
		InfoMergerBuilderV3<StatarchInfo, CountryInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StatarchVisiMergeCountry());
		InfoMergerV3<StatarchInfo, CountryInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
