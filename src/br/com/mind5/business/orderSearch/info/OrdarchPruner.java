package br.com.mind5.business.orderSearch.info;

import java.util.List;

import br.com.mind5.info.InfoPruner;
import br.com.mind5.info.InfoPrunerBuilder;

public final class OrdarchPruner {
	public static List<OrdarchInfo> pruneInactive(List<OrdarchInfo> baseInfos) {
		InfoPrunerBuilder<OrdarchInfo, OrdarchInfo> builder = new InfoPrunerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(baseInfos);
		builder.addVisitor(new OrdarchVisiPruneInactive());
		InfoPruner<OrdarchInfo, OrdarchInfo> pruner = builder.build();		
	
		return pruner.prune();
	}
}
