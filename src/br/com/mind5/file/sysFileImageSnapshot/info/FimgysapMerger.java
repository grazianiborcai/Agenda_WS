package br.com.mind5.file.sysFileImageSnapshot.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class FimgysapMerger {	
	public static List<FimgysapInfo> mergeToSelect(List<FimgysapInfo> baseInfos, List<FimgysapInfo> selectedInfos) {
		InfoMergerBuilder<FimgysapInfo, FimgysapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgysapMergerVisiToSelect());
		InfoMerger<FimgysapInfo, FimgysapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
