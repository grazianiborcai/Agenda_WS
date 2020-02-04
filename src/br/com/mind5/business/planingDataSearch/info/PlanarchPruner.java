package br.com.mind5.business.planingDataSearch.info;

import java.util.List;

import br.com.mind5.info.InfoPruner;
import br.com.mind5.info.InfoPrunerBuilder;

public final class PlanarchPruner {

	public static List<PlanarchInfo> pruneSel(List<PlanarchInfo> baseInfos) {
		InfoPrunerBuilder<PlanarchInfo, PlanarchInfo> builder = new InfoPrunerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(baseInfos);
		builder.addVisitor(new PlanarchVisiPruneSel());
		InfoPruner<PlanarchInfo, PlanarchInfo> pruner = builder.build();		
	
		return pruner.prune();
	}
}
