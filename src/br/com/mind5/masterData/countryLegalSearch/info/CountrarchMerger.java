package br.com.mind5.masterData.countryLegalSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class CountrarchMerger {	
	public static List<CountrarchInfo> mergeToSelect(List<CountrarchInfo> baseInfos, List<CountrarchInfo> selectedInfos) {
		InfoMergerBuilderV3<CountrarchInfo, CountrarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CountrarchVisiMergeToSelect());
		InfoMergerV3<CountrarchInfo, CountrarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
