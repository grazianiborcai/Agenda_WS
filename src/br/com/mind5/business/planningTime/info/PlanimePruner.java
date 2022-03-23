package br.com.mind5.business.planningTime.info;

import java.util.List;

import br.com.mind5.info.InfoPruner;
import br.com.mind5.info.InfoPrunerBuilder;

public final class PlanimePruner {
	public static List<PlanimeInfo> pruneWithDaypart(List<PlanimeInfo> baseInfos) {
		InfoPrunerBuilder<PlanimeInfo, PlanimeInfo> builder = new InfoPrunerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(baseInfos);
		builder.addVisitor(new PlanimePrunerVisiDaypart());
		InfoPruner<PlanimeInfo, PlanimeInfo> pruner = builder.build();		
	
		return pruner.prune();
	}
}
