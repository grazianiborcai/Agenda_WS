package br.com.mind5.business.home.info;

import java.util.List;

import br.com.mind5.business.cartCounter.info.CartouInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.security.userHome.info.UsomeInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class HomeMerger {	
	public static List<HomeInfo> mergeWithUsome(List<HomeInfo> baseInfos, List<UsomeInfo> selectedInfos) {
		InfoMergerBuilder<HomeInfo, UsomeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new HomeVisiMergeUsome());
		InfoMerger<HomeInfo, UsomeInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<HomeInfo> mergeWithCartou(List<HomeInfo> baseInfos, List<CartouInfo> selectedInfos) {
		InfoMergerBuilder<HomeInfo, CartouInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new HomeVisiMergeCartou());
		InfoMerger<HomeInfo, CartouInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<HomeInfo> mergeWithUsername(List<HomeInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<HomeInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new HomeVisiMergeUsername());
		InfoMerger<HomeInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
