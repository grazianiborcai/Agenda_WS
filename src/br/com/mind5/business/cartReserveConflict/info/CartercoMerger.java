package br.com.mind5.business.cartReserveConflict.info;

import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class CartercoMerger {	
	public static List<CartercoInfo> mergeWithCarterve(List<CartercoInfo> baseInfos, List<CarterveInfo> selectedInfos) {
		InfoMergerBuilder<CartercoInfo, CarterveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CartercoMergerVisiCarterve());
		InfoMerger<CartercoInfo, CarterveInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
