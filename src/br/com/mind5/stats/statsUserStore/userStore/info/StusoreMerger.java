package br.com.mind5.stats.statsUserStore.userStore.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsUserStore.userStoreAggr.info.StusoraggInfo;
import br.com.mind5.stats.statsUserStore.userStoreLive.info.StusoreveInfo;

public final class StusoreMerger {
	public static List<StusoreInfo> mergeWithStusoragg(List<StusoreInfo> baseInfos, List<StusoraggInfo> selectedInfos) {
		InfoMergerBuilder<StusoreInfo, StusoraggInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StusoreVisiMergeStusoragg());
		InfoMerger<StusoreInfo, StusoraggInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StusoreInfo> mergeWithStusoreve(List<StusoreInfo> baseInfos, List<StusoreveInfo> selectedInfos) {
		InfoMergerBuilder<StusoreInfo, StusoreveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StusoreVisiMergeStusoreve());
		InfoMerger<StusoreInfo, StusoreveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
