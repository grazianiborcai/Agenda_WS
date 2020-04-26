package br.com.mind5.business.cartItemSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class CartemarchMerger {
	public static List<CartemarchInfo> mergeToSelect(List<CartemarchInfo> baseInfos, List<CartemarchInfo> selectedInfos) {
		InfoMergerBuilderV3<CartemarchInfo, CartemarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartemarchVisiMergeToSelect());
		InfoMergerV3<CartemarchInfo, CartemarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
