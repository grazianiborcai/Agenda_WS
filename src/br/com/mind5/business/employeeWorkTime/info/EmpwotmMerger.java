package br.com.mind5.business.employeeWorkTime.info;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class EmpwotmMerger {	
	public static List<EmpwotmInfo> mergeWithStowotm(List<EmpwotmInfo> baseInfos, List<StowotmInfo> selectedInfos) {
		InfoMergerBuilder<EmpwotmInfo, StowotmInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwotmMergerVisiStowotm());
		InfoMerger<EmpwotmInfo, StowotmInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<EmpwotmInfo> mergeWithEmpwout(List<EmpwotmInfo> baseInfos, List<EmpwoutInfo> selectedInfos) {
		InfoMergerBuilder<EmpwotmInfo, EmpwoutInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwotmMergerVisiEmpwout());
		InfoMerger<EmpwotmInfo, EmpwoutInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<EmpwotmInfo> mergeWithEmpwoco(List<EmpwotmInfo> baseInfos, List<EmpwocoInfo> selectedInfos) {
		InfoMergerBuilder<EmpwotmInfo, EmpwocoInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwotmMergerVisiEmpwoco());
		InfoMerger<EmpwotmInfo, EmpwocoInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<EmpwotmInfo> mergeWithEmpwotarch(List<EmpwotmInfo> baseInfos, List<EmpwotarchInfo> selectedInfos) {
		InfoMergerBuilder<EmpwotmInfo, EmpwotarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwotmMergerVisiEmpwotarch());
		InfoMerger<EmpwotmInfo, EmpwotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<EmpwotmInfo> mergeWithStolis(List<EmpwotmInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<EmpwotmInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwotmMergerVisiStolis());
		InfoMerger<EmpwotmInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<EmpwotmInfo> mergeWithUsername(List<EmpwotmInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<EmpwotmInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwotmMergerVisiUsername());
		InfoMerger<EmpwotmInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpwotmInfo> mergeWithWeekday(List<EmpwotmInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilder<EmpwotmInfo, WeekdayInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwotmMergerVisiWeekday());
		InfoMerger<EmpwotmInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpwotmInfo> mergeToDelete(List<EmpwotmInfo> baseInfos, List<EmpwotmInfo> selectedInfos) {
		InfoMergerBuilder<EmpwotmInfo, EmpwotmInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwotmMergerVisiToDelete());
		InfoMerger<EmpwotmInfo, EmpwotmInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpwotmInfo> mergeToSelect(List<EmpwotmInfo> baseInfos, List<EmpwotmInfo> selectedInfos) {
		InfoMergerBuilder<EmpwotmInfo, EmpwotmInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpwotmMergerVisiToSelect());
		InfoMerger<EmpwotmInfo, EmpwotmInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
