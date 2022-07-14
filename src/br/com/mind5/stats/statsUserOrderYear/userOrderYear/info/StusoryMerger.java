package br.com.mind5.stats.statsUserOrderYear.userOrderYear.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.info.StusorygrInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLive.info.StusoryliInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.info.StusoryrchInfo;

public final class StusoryMerger {
	public static List<StusoryInfo> mergeWithStusoryrch(List<StusoryInfo> baseInfos, List<StusoryrchInfo> selectedInfos) {
		InfoMergerBuilder<StusoryInfo, StusoryrchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StusoryMergerVisiStusoryrch());
		InfoMerger<StusoryInfo, StusoryrchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StusoryInfo> mergeWithStusorygr(List<StusoryInfo> baseInfos, List<StusorygrInfo> selectedInfos) {
		InfoMergerBuilder<StusoryInfo, StusorygrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StusoryMergerVisiStusorygr());
		InfoMerger<StusoryInfo, StusorygrInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StusoryInfo> mergeWithStusoryli(List<StusoryInfo> baseInfos, List<StusoryliInfo> selectedInfos) {
		InfoMergerBuilder<StusoryInfo, StusoryliInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StusoryMergerVisiStusoryli());
		InfoMerger<StusoryInfo, StusoryliInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
