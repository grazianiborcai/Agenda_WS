package br.com.mind5.discount.discountCalculatorItem.info;

import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class DisalcemMerger {
	public static List<DisalcemInfo> mergeWithDisoupem(List<DisalcemInfo> baseInfos, List<DisoupemInfo> selectedInfos) {
		InfoMergerBuilder<DisalcemInfo, DisoupemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new DisalcemVisiMergeDisoupem());
		InfoMerger<DisalcemInfo, DisoupemInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<DisalcemInfo> mergeWithCartem(List<DisalcemInfo> baseInfos, List<CartemInfo> selectedInfos) {
		InfoMergerBuilder<DisalcemInfo, CartemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new DisalcemVisiMergeCartem());
		InfoMerger<DisalcemInfo, CartemInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<DisalcemInfo> mergeWithDisore(List<DisalcemInfo> baseInfos, List<DisoreInfo> selectedInfos) {
		InfoMergerBuilder<DisalcemInfo, DisoreInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new DisalcemVisiMergeDisore());
		InfoMerger<DisalcemInfo, DisoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
