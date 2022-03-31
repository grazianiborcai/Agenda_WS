package br.com.mind5.business.storeCatalogue.info;

import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;

public final class StogueMerger {
	public static List<StogueInfo> mergeWithMatoup(List<StogueInfo> baseInfos, List<MatoupInfo> selectedInfos) {
		InfoMergerBuilder<StogueInfo, MatoupInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StogueMergerVisiMatoup());
		InfoMerger<StogueInfo, MatoupInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StogueInfo> mergeWithOwnelis(List<StogueInfo> baseInfos, List<OwnelisInfo> selectedInfos) {
		InfoMergerBuilder<StogueInfo, OwnelisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StogueMergerVisiOwnelis());
		InfoMerger<StogueInfo, OwnelisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StogueInfo> mergeWithStorby(List<StogueInfo> baseInfos, List<StorbyInfo> selectedInfos) {
		InfoMergerBuilder<StogueInfo, StorbyInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StogueMergerVisiStorby());
		InfoMerger<StogueInfo, StorbyInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
