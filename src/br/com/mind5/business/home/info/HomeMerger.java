package br.com.mind5.business.home.info;

import java.util.List;

import br.com.mind5.business.cartCounter.info.CartouInfo;
import br.com.mind5.business.storeManager.info.StomanInfo;
import br.com.mind5.business.storeProspectCounter.info.StoprosouInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.security.userHome.info.UsomeInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class HomeMerger {	
	public static List<HomeInfo> mergeWithUsome(List<HomeInfo> baseInfos, List<UsomeInfo> selectedInfos) {
		InfoMergerBuilder<HomeInfo, UsomeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new HomeMergerVisiUsome());
		InfoMerger<HomeInfo, UsomeInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<HomeInfo> mergeWithStoman(List<HomeInfo> baseInfos, List<StomanInfo> selectedInfos) {
		InfoMergerBuilder<HomeInfo, StomanInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new HomeMergerVisiStoman());
		InfoMerger<HomeInfo, StomanInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<HomeInfo> mergeWithCartou(List<HomeInfo> baseInfos, List<CartouInfo> selectedInfos) {
		InfoMergerBuilder<HomeInfo, CartouInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new HomeMergerVisiCartou());
		InfoMerger<HomeInfo, CartouInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<HomeInfo> mergeWithStoprosou(List<HomeInfo> baseInfos, List<StoprosouInfo> selectedInfos) {
		InfoMergerBuilder<HomeInfo, StoprosouInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new HomeMergerVisiStoprosou());
		InfoMerger<HomeInfo, StoprosouInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<HomeInfo> mergeWithUsername(List<HomeInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<HomeInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new HomeMergerVisiUsername());
		InfoMerger<HomeInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
