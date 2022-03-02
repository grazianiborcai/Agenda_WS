package br.com.mind5.bot.botStats.botStatsStore.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.security.user.info.UserInfo;

public final class BostodMerger {
	public static List<BostodInfo> mergeWithDaemon(List<BostodInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilder<BostodInfo, UserInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BostodMergerVisiDaemon());
		InfoMerger<BostodInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<BostodInfo> mergeWithCalonth(List<BostodInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<BostodInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BostodMergerVisiCalonth());
		InfoMerger<BostodInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<BostodInfo> mergeWithStolis(List<BostodInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<BostodInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BostodMergerVisiStolis());
		InfoMerger<BostodInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
