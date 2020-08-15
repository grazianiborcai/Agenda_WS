package br.com.mind5.business.storeCatalogue.info;

import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class StogueMerger {
	public static List<StogueInfo> mergeStorby(List<StogueInfo> baseInfos, List<StorbyInfo> selectedInfos) {
		InfoMergerBuilderV3<StogueInfo, StorbyInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StogueVisiMergeStorby());
		InfoMergerV3<StogueInfo, StorbyInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
