package br.com.mind5.business.storeLeaveDate.info;

import java.util.List;

import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StolateMerger {
	public static List<StolateInfo> mergeWithStolis(List<StolateInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilderV3<StolateInfo, StolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolateVisiMergeStolis());
		InfoMergerV3<StolateInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StolateInfo> mergeWithStolarch(List<StolateInfo> baseInfos, List<StolarchInfo> selectedInfos) {
		InfoMergerBuilderV3<StolateInfo, StolarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolateVisiMergeStolarch());
		InfoMergerV3<StolateInfo, StolarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<StolateInfo> mergeWithUsername(List<StolateInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<StolateInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolateVisiMergeUsername());
		InfoMergerV3<StolateInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<StolateInfo> mergeToSelect(List<StolateInfo> baseInfos, List<StolateInfo> selectedInfos) {
		InfoMergerBuilderV3<StolateInfo, StolateInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolateVisiMergeToSelect());
		InfoMergerV3<StolateInfo, StolateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StolateInfo> mergeToDelete(List<StolateInfo> baseInfos, List<StolateInfo> selectedInfos) {
		InfoMergerBuilderV3<StolateInfo, StolateInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolateVisiMergeToDelete());
		InfoMergerV3<StolateInfo, StolateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StolateInfo> mergeToUpdate(List<StolateInfo> baseInfos, List<StolateInfo> selectedInfos) {
		InfoMergerBuilderV3<StolateInfo, StolateInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StolateVisiMergeToUpdate());
		InfoMergerV3<StolateInfo, StolateInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
