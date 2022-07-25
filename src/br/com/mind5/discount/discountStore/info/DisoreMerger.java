package br.com.mind5.discount.discountStore.info;

import java.util.List;

import br.com.mind5.discount.discountStoreSearch.info.DisorarchInfo;
import br.com.mind5.discount.discountStoreSnapshot.info.DisorapInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.discountStrategy.info.DisegyInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class DisoreMerger {
	public static List<DisoreInfo> mergeWithDisorap(List<DisoreInfo> baseInfos, List<DisorapInfo> selectedInfos) {
		InfoMergerBuilder<DisoreInfo, DisorapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new DisoreMergerVisiDisorap());
		InfoMerger<DisoreInfo, DisorapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<DisoreInfo> mergeWithDisorarch(List<DisoreInfo> baseInfos, List<DisorarchInfo> selectedInfos) {
		InfoMergerBuilder<DisoreInfo, DisorarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new DisoreMergerVisiDisorarch());
		InfoMerger<DisoreInfo, DisorarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<DisoreInfo> mergeWithDisegy(List<DisoreInfo> baseInfos, List<DisegyInfo> selectedInfos) {
		InfoMergerBuilder<DisoreInfo, DisegyInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new DisoreMergerVisiDisegy());
		InfoMerger<DisoreInfo, DisegyInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<DisoreInfo> mergeWithUsername(List<DisoreInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<DisoreInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new DisoreMergerVisiUsername());
		InfoMerger<DisoreInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<DisoreInfo> mergeToSelect(List<DisoreInfo> baseInfos, List<DisoreInfo> selectedInfos) {
		InfoMergerBuilder<DisoreInfo, DisoreInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new DisoreMergerVisiToSelect());
		InfoMerger<DisoreInfo, DisoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
