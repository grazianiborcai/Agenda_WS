package br.com.mind5.business.employeeLeaveDate.info;

import java.util.List;

import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class EmplateMerger {
	public static List<EmplateInfo> mergeWithEmplarch(List<EmplateInfo> baseInfos, List<EmplarchInfo> selectedInfos) {
		InfoMergerBuilderV3<EmplateInfo, EmplarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplateVisiMergeEmplarch());
		InfoMergerV3<EmplateInfo, EmplarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmplateInfo> mergeWithTimezone(List<EmplateInfo> baseInfos, List<TimezoneInfo> selectedInfos) {
		InfoMergerBuilderV3<EmplateInfo, TimezoneInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplateVisiMergeTimezone());
		InfoMergerV3<EmplateInfo, TimezoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmplateInfo> mergeWithUsername(List<EmplateInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<EmplateInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplateVisiMergeUsername());
		InfoMergerV3<EmplateInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmplateInfo> mergeToSelect(List<EmplateInfo> baseInfos, List<EmplateInfo> selectedInfos) {
		InfoMergerBuilderV3<EmplateInfo, EmplateInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplateVisiMergeToSelect());
		InfoMergerV3<EmplateInfo, EmplateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmplateInfo> mergeToDelete(List<EmplateInfo> baseInfos, List<EmplateInfo> selectedInfos) {
		InfoMergerBuilderV3<EmplateInfo, EmplateInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplateVisiMergeToDelete());
		InfoMergerV3<EmplateInfo, EmplateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmplateInfo> mergeToUpdate(List<EmplateInfo> baseInfos, List<EmplateInfo> selectedInfos) {
		InfoMergerBuilderV3<EmplateInfo, EmplateInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplateVisiMergeToUpdate());
		InfoMergerV3<EmplateInfo, EmplateInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
