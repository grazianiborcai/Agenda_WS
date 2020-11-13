package br.com.mind5.business.storeTextSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class StorextarchMerger {	
	public static List<StorextarchInfo> mergeToSelect(List<StorextarchInfo> baseInfos, List<StorextarchInfo> selectedInfos) {
		InfoMergerBuilder<StorextarchInfo, StorextarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorextarchVisiMergeToSelect());
		InfoMerger<StorextarchInfo, StorextarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
