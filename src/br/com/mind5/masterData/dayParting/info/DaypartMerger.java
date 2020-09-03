package br.com.mind5.masterData.dayParting.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.dayPartingSearch.info.DayparchInfo;

public final class DaypartMerger {
	public static List<DaypartInfo> mergeWithDayparch(List<DaypartInfo> baseInfos, List<DayparchInfo> selectedInfos) {
		InfoMergerBuilderV3<DaypartInfo, DayparchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new DaypartVisiMergeDayparch());
		InfoMergerV3<DaypartInfo, DayparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
