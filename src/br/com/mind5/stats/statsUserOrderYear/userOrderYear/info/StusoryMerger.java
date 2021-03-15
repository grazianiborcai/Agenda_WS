package br.com.mind5.stats.statsUserOrderYear.userOrderYear.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.info.StusorygrInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLive.info.StusoryliInfo;

public final class StusoryMerger {
	public static List<StusoryInfo> mergeWithStusorygr(List<StusoryInfo> baseInfos, List<StusorygrInfo> selectedInfos) {
		InfoMergerBuilder<StusoryInfo, StusorygrInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StusoryVisiMergeStusorygr());
		InfoMerger<StusoryInfo, StusorygrInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StusoryInfo> mergeWithStusoryli(List<StusoryInfo> baseInfos, List<StusoryliInfo> selectedInfos) {
		InfoMergerBuilder<StusoryInfo, StusoryliInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StusoryVisiMergeStusoryli());
		InfoMerger<StusoryInfo, StusoryliInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
