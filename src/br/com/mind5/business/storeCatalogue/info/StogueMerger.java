package br.com.mind5.business.storeCatalogue.info;

import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;

public final class StogueMerger {
	public static List<StogueInfo> mergeWithMatoup(List<StogueInfo> baseInfos, List<MatoupInfo> selectedInfos) {
		InfoMergerBuilderV3<StogueInfo, MatoupInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StogueVisiMergeMatoup());
		InfoMergerV3<StogueInfo, MatoupInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StogueInfo> mergeWithOwnelis(List<StogueInfo> baseInfos, List<OwnelisInfo> selectedInfos) {
		InfoMergerBuilderV3<StogueInfo, OwnelisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StogueVisiMergeOwnelis());
		InfoMergerV3<StogueInfo, OwnelisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StogueInfo> mergeWithStorby(List<StogueInfo> baseInfos, List<StorbyInfo> selectedInfos) {
		InfoMergerBuilderV3<StogueInfo, StorbyInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StogueVisiMergeStorby());
		InfoMergerV3<StogueInfo, StorbyInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
