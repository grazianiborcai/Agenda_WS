package br.com.mind5.business.cartItemSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class CartemarchMerger {
	public static List<CartemarchInfo> mergeToSelect(List<CartemarchInfo> baseInfos, List<CartemarchInfo> selectedInfos) {
		InfoMergerBuilder<CartemarchInfo, CartemarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartemarchMergerVisiToSelect());
		InfoMerger<CartemarchInfo, CartemarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
