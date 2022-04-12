package br.com.mind5.business.storeTextDefault.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class StorextaultMerger {	
	public static List<StorextaultInfo> mergeToSelect(List<StorextaultInfo> baseInfos, List<StorextaultInfo> selectedInfos) {
		InfoMergerBuilder<StorextaultInfo, StorextaultInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorextaultMergeVisiToSelect());
		InfoMerger<StorextaultInfo, StorextaultInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
