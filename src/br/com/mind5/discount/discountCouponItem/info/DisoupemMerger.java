package br.com.mind5.discount.discountCouponItem.info;

import java.util.List;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.discount.discountStoreSnapshot.info.DisorapInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.security.username.info.UsernameInfo;

public final class DisoupemMerger {
	public static List<DisoupemInfo> mergeWithDisore(List<DisoupemInfo> baseInfos, List<DisoreInfo> selectedInfos) {
		InfoMergerBuilder<DisoupemInfo, DisoreInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new DisoupemMergerVisiDisore());
		InfoMerger<DisoupemInfo, DisoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<DisoupemInfo> mergeWithDisorap(List<DisoupemInfo> baseInfos, List<DisorapInfo> selectedInfos) {
		InfoMergerBuilder<DisoupemInfo, DisorapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new DisoupemMergerVisiDisorap());
		InfoMerger<DisoupemInfo, DisorapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<DisoupemInfo> mergeWithUsername(List<DisoupemInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<DisoupemInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new DisoupemMergerVisiUsername());
		InfoMerger<DisoupemInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<DisoupemInfo> mergeToSelect(List<DisoupemInfo> baseInfos, List<DisoupemInfo> selectedInfos) {
		InfoMergerBuilder<DisoupemInfo, DisoupemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new DisoupemMergerVisiToSelect());
		InfoMerger<DisoupemInfo, DisoupemInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
