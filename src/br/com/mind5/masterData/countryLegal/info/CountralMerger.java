package br.com.mind5.masterData.countryLegal.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.masterData.countryLegalSearch.info.CountrarchInfo;

public final class CountralMerger {	
	public static List<CountralInfo> mergeWithCountrarch(List<CountralInfo> baseInfos, List<CountrarchInfo> selectedInfos) {
		InfoMergerBuilder<CountralInfo, CountrarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CountralVisiMergeCountrarch());
		InfoMerger<CountralInfo, CountrarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CountralInfo> mergeWithCountry(List<CountralInfo> baseInfos, List<CountryInfo> selectedInfos) {
		InfoMergerBuilder<CountralInfo, CountryInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CountralVisiMergeCountry());
		InfoMerger<CountralInfo, CountryInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CountralInfo> mergeToSelect(List<CountralInfo> baseInfos, List<CountralInfo> selectedInfos) {
		InfoMergerBuilder<CountralInfo, CountralInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CountralVisiMergeToSelect());
		InfoMerger<CountralInfo, CountralInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
