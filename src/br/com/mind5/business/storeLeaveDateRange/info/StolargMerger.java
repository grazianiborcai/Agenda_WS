package br.com.mind5.business.storeLeaveDateRange.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class StolargMerger {
	public static List<StolargInfo> mergeToSelect(List<StolargInfo> baseInfos, List<StolargInfo> selectedInfos) {
		InfoMergerBuilder<StolargInfo, StolargInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolargVisiMergeToSelect());
		InfoMerger<StolargInfo, StolargInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
