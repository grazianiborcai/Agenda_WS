package br.com.mind5.masterData.weekday.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.weekdaySearch.info.WeekdarchInfo;

public final class WeekdayMerger {
	public static List<WeekdayInfo> mergeWithWeekdarch(List<WeekdayInfo> baseInfos, List<WeekdarchInfo> selectedInfos) {
		InfoMergerBuilder<WeekdayInfo, WeekdarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new WeekdayMergerVisiWeekdarch());
		InfoMerger<WeekdayInfo, WeekdarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
