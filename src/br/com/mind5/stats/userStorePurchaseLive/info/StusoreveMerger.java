package br.com.mind5.stats.userStorePurchaseLive.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class StusoreveMerger {
	public static List<StusoreveInfo> mergeToSelect(List<StusoreveInfo> baseInfos, List<StusoreveInfo> selectedInfos) {
		InfoMergerBuilder<StusoreveInfo, StusoreveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StusoreveVisiMergeToSelect());
		InfoMerger<StusoreveInfo, StusoreveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
