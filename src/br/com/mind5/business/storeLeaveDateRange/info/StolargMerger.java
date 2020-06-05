package br.com.mind5.business.storeLeaveDateRange.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class StolargMerger {
	public static List<StolargInfo> mergeToSelect(List<StolargInfo> baseInfos, List<StolargInfo> selectedInfos) {
		InfoMergerBuilderV3<StolargInfo, StolargInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolargVisiMergeToSelect());
		InfoMergerV3<StolargInfo, StolargInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
