package br.com.mind5.masterData.state.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.country.info.CountryInfo;

public final class StateMerger {	
	public static List<StateInfo> mergeWithCountry(List<StateInfo> baseInfos, List<CountryInfo> selectedInfos) {
		InfoMergerBuilder<StateInfo, CountryInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StateVisiMergeCountry());
		InfoMerger<StateInfo, CountryInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
