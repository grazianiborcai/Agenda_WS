package br.com.mind5.business.employeeLeaveDateRange.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class EmplargMerger {
	public static List<EmplargInfo> mergeToSelect(List<EmplargInfo> baseInfos, List<EmplargInfo> selectedInfos) {
		InfoMergerBuilder<EmplargInfo, EmplargInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplargMergerVisiToSelect());
		InfoMerger<EmplargInfo, EmplargInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
