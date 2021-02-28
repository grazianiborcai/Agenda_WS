package br.com.mind5.stats.userOrderYearLive.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class StusoryliMerger {
	public static List<StusoryliInfo> mergeToSelect(List<StusoryliInfo> baseInfos, List<StusoryliInfo> selectedInfos) {
		InfoMergerBuilder<StusoryliInfo, StusoryliInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StusoryliVisiMergeToSelect());
		InfoMerger<StusoryliInfo, StusoryliInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
