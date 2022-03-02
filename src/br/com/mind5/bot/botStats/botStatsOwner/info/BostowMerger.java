package br.com.mind5.bot.botStats.botStatsOwner.info;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.security.user.info.UserInfo;

public final class BostowMerger {
	public static List<BostowInfo> mergeWithDaemon(List<BostowInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilder<BostowInfo, UserInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BostowMergerVisiDaemon());
		InfoMerger<BostowInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<BostowInfo> mergeWithCalonth(List<BostowInfo> baseInfos, List<CalonthInfo> selectedInfos) {
		InfoMergerBuilder<BostowInfo, CalonthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BostowMergerVisiCalonth());
		InfoMerger<BostowInfo, CalonthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<BostowInfo> mergeWithStolis(List<BostowInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<BostowInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new BostowMergerVisiStolis());
		InfoMerger<BostowInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
