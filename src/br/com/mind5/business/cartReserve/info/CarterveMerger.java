package br.com.mind5.business.cartReserve.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class CarterveMerger {	
	public static List<CarterveInfo> mergeToSelect(List<CarterveInfo> baseInfos, List<CarterveInfo> selectedInfos) {
		InfoMergerBuilderV3<CarterveInfo, CarterveInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CarterveVisiMergeToSelect());
		InfoMergerV3<CarterveInfo, CarterveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
