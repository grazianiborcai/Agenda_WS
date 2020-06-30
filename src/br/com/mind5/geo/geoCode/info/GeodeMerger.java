package br.com.mind5.geo.geoCode.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.country.info.CountryInfo;
import br.com.mind5.masterData.state.info.StateInfo;

public final class GeodeMerger {
	public static List<GeodeInfo> mergeWithCountry(List<GeodeInfo> baseInfos, List<CountryInfo> selectedInfos) {
		InfoMergerBuilderV3<GeodeInfo, CountryInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new GeodeVisiMergeCountry());
		InfoMergerV3<GeodeInfo, CountryInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<GeodeInfo> mergeWithState(List<GeodeInfo> baseInfos, List<StateInfo> selectedInfos) {
		InfoMergerBuilderV3<GeodeInfo, StateInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new GeodeVisiMergeState());
		InfoMergerV3<GeodeInfo, StateInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
