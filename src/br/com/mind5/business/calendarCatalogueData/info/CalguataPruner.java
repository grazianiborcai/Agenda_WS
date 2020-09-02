package br.com.mind5.business.calendarCatalogueData.info;

import java.util.List;

import br.com.mind5.info.InfoPruner;
import br.com.mind5.info.InfoPrunerBuilder;

public final class CalguataPruner {
	public static List<CalguataInfo> pruneAged(List<CalguataInfo> baseInfos) {
		InfoPrunerBuilder<CalguataInfo, CalguataInfo> builder = new InfoPrunerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(baseInfos);
		builder.addVisitor(new CalguataVisiPruneAged());
		InfoPruner<CalguataInfo, CalguataInfo> pruner = builder.build();		
	
		return pruner.prune();
	}
}
