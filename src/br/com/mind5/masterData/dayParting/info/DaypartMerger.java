package br.com.mind5.masterData.dayParting.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.dayPartingSearch.info.DayparchInfo;

public final class DaypartMerger {
	public static List<DaypartInfo> mergeWithDayparch(List<DaypartInfo> baseInfos, List<DayparchInfo> selectedInfos) {
		InfoMergerBuilder<DaypartInfo, DayparchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new DaypartMergerVisiDayparch());
		InfoMerger<DaypartInfo, DayparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
