package br.com.mind5.masterData.countryLegalSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class CountrarchMerger {	
	public static List<CountrarchInfo> mergeToSelect(List<CountrarchInfo> baseInfos, List<CountrarchInfo> selectedInfos) {
		InfoMergerBuilder<CountrarchInfo, CountrarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CountrarchVisiMergeToSelect());
		InfoMerger<CountrarchInfo, CountrarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
