package br.com.mind5.business.employeeLeaveDate.info;

import java.util.List;

import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.timezone.info.TimezoneInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class EmplateMerger {
	public static List<EmplateInfo> mergeWithEmplarch(List<EmplateInfo> baseInfos, List<EmplarchInfo> selectedInfos) {
		InfoMergerBuilder<EmplateInfo, EmplarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplateMergerVisiEmplarch());
		InfoMerger<EmplateInfo, EmplarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmplateInfo> mergeWithTimezone(List<EmplateInfo> baseInfos, List<TimezoneInfo> selectedInfos) {
		InfoMergerBuilder<EmplateInfo, TimezoneInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplateMergerVisiTimezone());
		InfoMerger<EmplateInfo, TimezoneInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmplateInfo> mergeWithUsername(List<EmplateInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<EmplateInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplateMergerVisiUsername());
		InfoMerger<EmplateInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmplateInfo> mergeToSelect(List<EmplateInfo> baseInfos, List<EmplateInfo> selectedInfos) {
		InfoMergerBuilder<EmplateInfo, EmplateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplateMergerVisiToSelect());
		InfoMerger<EmplateInfo, EmplateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmplateInfo> mergeToDelete(List<EmplateInfo> baseInfos, List<EmplateInfo> selectedInfos) {
		InfoMergerBuilder<EmplateInfo, EmplateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplateMergerVisiToDelete());
		InfoMerger<EmplateInfo, EmplateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmplateInfo> mergeToUpdate(List<EmplateInfo> baseInfos, List<EmplateInfo> selectedInfos) {
		InfoMergerBuilder<EmplateInfo, EmplateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplateMergerVisiToUpdate());
		InfoMerger<EmplateInfo, EmplateInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
