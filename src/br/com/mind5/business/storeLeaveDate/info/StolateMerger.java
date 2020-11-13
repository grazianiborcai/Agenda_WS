package br.com.mind5.business.storeLeaveDate.info;

import java.util.List;

import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StolateMerger {
	public static List<StolateInfo> mergeWithStolis(List<StolateInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<StolateInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolateVisiMergeStolis());
		InfoMerger<StolateInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StolateInfo> mergeWithStolarch(List<StolateInfo> baseInfos, List<StolarchInfo> selectedInfos) {
		InfoMergerBuilder<StolateInfo, StolarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolateVisiMergeStolarch());
		InfoMerger<StolateInfo, StolarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<StolateInfo> mergeWithUsername(List<StolateInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<StolateInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolateVisiMergeUsername());
		InfoMerger<StolateInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<StolateInfo> mergeToSelect(List<StolateInfo> baseInfos, List<StolateInfo> selectedInfos) {
		InfoMergerBuilder<StolateInfo, StolateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolateVisiMergeToSelect());
		InfoMerger<StolateInfo, StolateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StolateInfo> mergeToDelete(List<StolateInfo> baseInfos, List<StolateInfo> selectedInfos) {
		InfoMergerBuilder<StolateInfo, StolateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolateVisiMergeToDelete());
		InfoMerger<StolateInfo, StolateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StolateInfo> mergeToUpdate(List<StolateInfo> baseInfos, List<StolateInfo> selectedInfos) {
		InfoMergerBuilder<StolateInfo, StolateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolateVisiMergeToUpdate());
		InfoMerger<StolateInfo, StolateInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
