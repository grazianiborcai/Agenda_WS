package br.com.mind5.masterData.state.info;

import java.util.List;

import br.com.mind5.business.masterData.info.CountryInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class StateMerger {	
	public static List<StateInfo> mergeWithCountry(List<StateInfo> baseInfos, List<CountryInfo> selectedInfos) {
		InfoMergerBuilderV3<StateInfo, CountryInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StateVisiMergeCountry());
		InfoMergerV3<StateInfo, CountryInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
