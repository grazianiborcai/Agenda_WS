package br.com.mind5.business.cartCounter.info;

import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CartouMerger {	
	public static List<CartouInfo> mergeWithCartem(List<CartouInfo> baseInfos, List<CartemInfo> selectedInfos) {
		InfoMergerBuilder<CartouInfo, CartemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartouMergerVisiCartem());
		InfoMerger<CartouInfo, CartemInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<CartouInfo> mergeWithUsername(List<CartouInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<CartouInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartouMergerVisiUsername());
		InfoMerger<CartouInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
