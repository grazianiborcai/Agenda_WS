package br.com.mind5.file.fileImageSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class FimarchMerger {		
	public static List<FimarchInfo> mergeToSelect(List<FimarchInfo> baseInfos, List<FimarchInfo> selectedInfos) {
		InfoMergerBuilderV3<FimarchInfo, FimarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimarchVisiMergeToSelect());
		InfoMergerV3<FimarchInfo, FimarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
