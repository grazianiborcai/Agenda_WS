package br.com.mind5.geo.geoCode.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.masterData.state.info.StateInfo;

public final class GeodeMerger {
	public static List<GeodeInfo> mergeWithCountry(List<GeodeInfo> baseInfos, List<CountryInfo> selectedInfos) {
		InfoMergerBuilder<GeodeInfo, CountryInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new GeodeMergerVisiCountry());
		InfoMerger<GeodeInfo, CountryInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<GeodeInfo> mergeWithState(List<GeodeInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilder<GeodeInfo, StateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new GeodeMergerVisiState());
		InfoMerger<GeodeInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
