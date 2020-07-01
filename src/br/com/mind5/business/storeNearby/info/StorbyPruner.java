package br.com.mind5.business.storeNearby.info;

import java.util.List;

import br.com.mind5.info.InfoPruner;
import br.com.mind5.info.InfoPrunerBuilder;

public final class StorbyPruner {
	public static List<StorbyInfo> pruneEmpty(List<StorbyInfo> baseInfos) {
		InfoPrunerBuilder<StorbyInfo, StorbyInfo> builder = new InfoPrunerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(baseInfos);
		builder.addVisitor(new StorbyVisiPruneEmpty());
		InfoPruner<StorbyInfo, StorbyInfo> pruner = builder.build();		
	
		return pruner.prune();
	}
}
