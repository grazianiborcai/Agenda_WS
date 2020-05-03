package br.com.mind5.business.cartReserveConflict.info;

import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class CartercoMerger {	
	public static List<CartercoInfo> mergeWithCarterve(List<CartercoInfo> baseInfos, List<CarterveInfo> selectedInfos) {
		InfoMergerBuilderV3<CartercoInfo, CarterveInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartercoVisiMergeCarterve());
		InfoMergerV3<CartercoInfo, CarterveInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
