package br.com.mind5.masterData.countryLegal.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.masterData.countryLegalSearch.info.CountrarchInfo;

public final class CountralMerger {	
	public static List<CountralInfo> mergeWithCountrarch(List<CountralInfo> baseInfos, List<CountrarchInfo> selectedInfos) {
		InfoMergerBuilderV3<CountralInfo, CountrarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CountralVisiMergeCountrarch());
		InfoMergerV3<CountralInfo, CountrarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CountralInfo> mergeWithCountry(List<CountralInfo> baseInfos, List<CountryInfo> selectedInfos) {
		InfoMergerBuilderV3<CountralInfo, CountryInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CountralVisiMergeCountry());
		InfoMergerV3<CountralInfo, CountryInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CountralInfo> mergeToSelect(List<CountralInfo> baseInfos, List<CountralInfo> selectedInfos) {
		InfoMergerBuilderV3<CountralInfo, CountralInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CountralVisiMergeToSelect());
		InfoMergerV3<CountralInfo, CountralInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
