package br.com.mind5.business.employeeLeaveDateRange.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class EmplargMerger {
	public static List<EmplargInfo> mergeToSelect(List<EmplargInfo> baseInfos, List<EmplargInfo> selectedInfos) {
		InfoMergerBuilderV3<EmplargInfo, EmplargInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplargVisiMergeToSelect());
		InfoMergerV3<EmplargInfo, EmplargInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
