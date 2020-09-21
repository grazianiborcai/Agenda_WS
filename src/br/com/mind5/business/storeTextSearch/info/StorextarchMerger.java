package br.com.mind5.business.storeTextSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class StorextarchMerger {	
	public static List<StorextarchInfo> mergeToSelect(List<StorextarchInfo> baseInfos, List<StorextarchInfo> selectedInfos) {
		InfoMergerBuilderV3<StorextarchInfo, StorextarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorextarchVisiMergeToSelect());
		InfoMergerV3<StorextarchInfo, StorextarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
