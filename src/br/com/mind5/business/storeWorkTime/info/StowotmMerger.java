package br.com.mind5.business.storeWorkTime.info;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StowotmMerger {
	public static List<StowotmInfo> mergeWithSytotauh(List<StowotmInfo> baseInfos, List<SytotauhInfo> selectedInfos) {
		InfoMergerBuilderV3<StowotmInfo, SytotauhInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmVisiMergeSytotauh());
		InfoMergerV3<StowotmInfo, SytotauhInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StowotmInfo> mergeWithStowotarch(List<StowotmInfo> baseInfos, List<StowotarchInfo> selectedInfos) {
		InfoMergerBuilderV3<StowotmInfo, StowotarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmVisiMergeStowotarch());
		InfoMergerV3<StowotmInfo, StowotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StowotmInfo> mergeWithWeekday(List<StowotmInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilderV3<StowotmInfo, WeekdayInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmVisiMergeWeekday());
		InfoMergerV3<StowotmInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StowotmInfo> mergeWithStolis(List<StowotmInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilderV3<StowotmInfo, StolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmVisiMergeStolis());
		InfoMergerV3<StowotmInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StowotmInfo> mergeWithUsername(List<StowotmInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<StowotmInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmVisiMergeUsername());
		InfoMergerV3<StowotmInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StowotmInfo> mergeToSelect(List<StowotmInfo> baseInfos, List<StowotmInfo> selectedInfos) {
		InfoMergerBuilderV3<StowotmInfo, StowotmInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmVisiMergeToSelect());
		InfoMergerV3<StowotmInfo, StowotmInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StowotmInfo> mergeToDelete(List<StowotmInfo> baseInfos, List<StowotmInfo> selectedInfos) {
		InfoMergerBuilderV3<StowotmInfo, StowotmInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmVisiMergeToDelete());
		InfoMergerV3<StowotmInfo, StowotmInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	

	public static List<StowotmInfo> mergeToUpdate(List<StowotmInfo> baseInfos, List<StowotmInfo> selectedInfos) {
		InfoMergerBuilderV3<StowotmInfo, StowotmInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StowotmVisiMergeToUpdate());
		InfoMergerV3<StowotmInfo, StowotmInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
