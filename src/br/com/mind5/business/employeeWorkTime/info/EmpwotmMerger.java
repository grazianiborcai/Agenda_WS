package br.com.mind5.business.employeeWorkTime.info;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.username.info.UsernameInfo;

public final class EmpwotmMerger {	
	public static List<EmpwotmInfo> mergeWithStowotarch(List<EmpwotmInfo> baseInfos, List<StowotarchInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpwotmInfo, StowotarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwotmVisiMergeStowotarch());
		InfoMergerV3<EmpwotmInfo, StowotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<EmpwotmInfo> mergeWithEmpwout(List<EmpwotmInfo> baseInfos, List<EmpwoutInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpwotmInfo, EmpwoutInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwotmVisiMergeEmpwout());
		InfoMergerV3<EmpwotmInfo, EmpwoutInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<EmpwotmInfo> mergeWithEmpwoco(List<EmpwotmInfo> baseInfos, List<EmpwocoInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpwotmInfo, EmpwocoInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwotmVisiMergeEmpwoco());
		InfoMergerV3<EmpwotmInfo, EmpwocoInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<EmpwotmInfo> mergeWithEmpwotarch(List<EmpwotmInfo> baseInfos, List<EmpwotarchInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpwotmInfo, EmpwotarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwotmVisiMergeEmpwotarch());
		InfoMergerV3<EmpwotmInfo, EmpwotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<EmpwotmInfo> mergeWithTimezone(List<EmpwotmInfo> baseInfos, List<TimezoneInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpwotmInfo, TimezoneInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwotmVisiMergeTimezone());
		InfoMergerV3<EmpwotmInfo, TimezoneInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<EmpwotmInfo> mergeWithUsername(List<EmpwotmInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpwotmInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwotmVisiMergeUsername());
		InfoMergerV3<EmpwotmInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpwotmInfo> mergeWithWeekday(List<EmpwotmInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpwotmInfo, WeekdayInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwotmVisiMergeWeekday());
		InfoMergerV3<EmpwotmInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpwotmInfo> mergeToDelete(List<EmpwotmInfo> baseInfos, List<EmpwotmInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpwotmInfo, EmpwotmInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwotmVisiMergeToDelete());
		InfoMergerV3<EmpwotmInfo, EmpwotmInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpwotmInfo> mergeToSelect(List<EmpwotmInfo> baseInfos, List<EmpwotmInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpwotmInfo, EmpwotmInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwotmVisiMergeToSelect());
		InfoMergerV3<EmpwotmInfo, EmpwotmInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
