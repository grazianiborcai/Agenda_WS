package br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info.StusorylirchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info.StusorygerchInfo;

public final class StusoryrchMerger {
	public static List<StusoryrchInfo> mergeWithStusorygerch(List<StusoryrchInfo> baseInfos, List<StusorygerchInfo> selectedInfos) {
		InfoMergerBuilder<StusoryrchInfo, StusorygerchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StusoryrchVisiMergeStusorygerch());
		InfoMerger<StusoryrchInfo, StusorygerchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StusoryrchInfo> mergeWithStusorygrarch(List<StusoryrchInfo> baseInfos, List<StusorygrarchInfo> selectedInfos) {
		InfoMergerBuilder<StusoryrchInfo, StusorygrarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StusoryrchVisiMergeStusorygrarch());
		InfoMerger<StusoryrchInfo, StusorygrarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StusoryrchInfo> mergeWithStusorylirch(List<StusoryrchInfo> baseInfos, List<StusorylirchInfo> selectedInfos) {
		InfoMergerBuilder<StusoryrchInfo, StusorylirchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StusoryrchVisiMergeStusorylirch());
		InfoMerger<StusoryrchInfo, StusorylirchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
