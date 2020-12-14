package br.com.mind5.stats.userStoreStgn.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class StusorageMerger {
	public static List<StusorageInfo> mergeToSelect(List<StusorageInfo> baseInfos, List<StusorageInfo> selectedInfos) {
		InfoMergerBuilder<StusorageInfo, StusorageInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StusorageVisiMergeToSelect());
		InfoMerger<StusorageInfo, StusorageInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
