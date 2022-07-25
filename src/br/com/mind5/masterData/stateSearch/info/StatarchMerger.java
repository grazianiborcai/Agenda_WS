package br.com.mind5.masterData.stateSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.country.info.CountryInfo;

public final class StatarchMerger {	
	public static List<StatarchInfo> mergeWithCountry(List<StatarchInfo> baseInfos, List<CountryInfo> selectedInfos) {
		InfoMergerBuilder<StatarchInfo, CountryInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StatarchMergerVisiCountry());
		InfoMerger<StatarchInfo, CountryInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
