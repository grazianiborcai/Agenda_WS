package br.com.mind5.business.cartReserve.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class CarterveMerger {	
	public static List<CarterveInfo> mergeToSelect(List<CarterveInfo> baseInfos, List<CarterveInfo> selectedInfos) {
		InfoMergerBuilder<CarterveInfo, CarterveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CarterveVisiMergeToSelect());
		InfoMerger<CarterveInfo, CarterveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
