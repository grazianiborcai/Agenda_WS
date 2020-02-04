package br.com.mind5.business.cartReserveConflict.info;

import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.info.InfoPruner;
import br.com.mind5.info.InfoPrunerBuilder;

public final class CartercoPruner {	
	
	public static List<CartercoInfo> pruneWithCarterve(List<CartercoInfo> baseInfos, List<CarterveInfo> selectedInfos) {
		InfoPrunerBuilder<CartercoInfo, CarterveInfo> builder = new InfoPrunerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartercoVisiPruneCarterve());
		InfoPruner<CartercoInfo, CarterveInfo> pruner = builder.build();		
	
		return pruner.prune();
	}
}
