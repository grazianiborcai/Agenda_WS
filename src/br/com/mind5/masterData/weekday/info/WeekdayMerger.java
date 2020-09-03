package br.com.mind5.masterData.weekday.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.weekdaySearch.info.WeekdarchInfo;

public final class WeekdayMerger {
	public static List<WeekdayInfo> mergeWithWeekdarch(List<WeekdayInfo> baseInfos, List<WeekdarchInfo> selectedInfos) {
		InfoMergerBuilderV3<WeekdayInfo, WeekdarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new WeekdayVisiMergeWeekdarch());
		InfoMergerV3<WeekdayInfo, WeekdarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
