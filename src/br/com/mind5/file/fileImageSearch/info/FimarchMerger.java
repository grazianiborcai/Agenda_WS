package br.com.mind5.file.fileImageSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class FimarchMerger {		
	public static List<FimarchInfo> mergeToSelect(List<FimarchInfo> baseInfos, List<FimarchInfo> selectedInfos) {
		InfoMergerBuilder<FimarchInfo, FimarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimarchMergerVisiToSelect());
		InfoMerger<FimarchInfo, FimarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
