package br.com.mind5.business.storeTextDefault.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class StorextaultMerger {	
	public static List<StorextaultInfo> mergeToSelect(List<StorextaultInfo> baseInfos, List<StorextaultInfo> selectedInfos) {
		InfoMergerBuilderV3<StorextaultInfo, StorextaultInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorextaultVisiMergeToSelect());
		InfoMergerV3<StorextaultInfo, StorextaultInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
