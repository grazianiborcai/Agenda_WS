package br.com.mind5.file.sysFileImageSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class FimgysarchMerger {		
	public static List<FimgysarchInfo> mergeToSelect(List<FimgysarchInfo> baseInfos, List<FimgysarchInfo> selectedInfos) {
		InfoMergerBuilder<FimgysarchInfo, FimgysarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgysarchMergerVisiToSelect());
		InfoMerger<FimgysarchInfo, FimgysarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
