package br.com.mind5.business.scheduleWeek.info;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarTimeEmployee.info.CalimempInfo;
import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class SchedeekMerger {
	public static List<SchedeekInfo> mergeWithCalimemp(List<SchedeekInfo> baseInfos, List<CalimempInfo> selectedInfos) {
		InfoMergerBuilder<SchedeekInfo, CalimempInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedeekMergerVisiCalimemp());
		InfoMerger<SchedeekInfo, CalimempInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedeekInfo> mergeWithCalimore(List<SchedeekInfo> baseInfos, List<CalimoreInfo> selectedInfos) {
		InfoMergerBuilder<SchedeekInfo, CalimoreInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedeekMergerVisiCalimore());
		InfoMerger<SchedeekInfo, CalimoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedeekInfo> mergeWithCalate(List<SchedeekInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilder<SchedeekInfo, CalateInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedeekMergerVisiCalate());
		InfoMerger<SchedeekInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedeekInfo> mergeWithCaleeky(List<SchedeekInfo> baseInfos, List<CaleekyInfo> selectedInfos) {
		InfoMergerBuilder<SchedeekInfo, CaleekyInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedeekMergerVisiCaleeky());
		InfoMerger<SchedeekInfo, CaleekyInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedeekInfo> mergeWithCuslis(List<SchedeekInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilder<SchedeekInfo, CuslisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedeekMergerVisiCuslis());
		InfoMerger<SchedeekInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedeekInfo> mergeWithEmplres(List<SchedeekInfo> baseInfos, List<EmplresInfo> selectedInfos) {
		InfoMergerBuilder<SchedeekInfo, EmplresInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedeekMergerVisiEmplres());
		InfoMerger<SchedeekInfo, EmplresInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedeekInfo> mergeWithMatlis(List<SchedeekInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilder<SchedeekInfo, MatlisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedeekMergerVisiMatlis());
		InfoMerger<SchedeekInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<SchedeekInfo> mergeWithStolis(List<SchedeekInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<SchedeekInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedeekMergerVisiStolis());
		InfoMerger<SchedeekInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedeekInfo> mergeWithSchedeekdat(List<SchedeekInfo> baseInfos, List<SchedeekdatInfo> selectedInfos) {
		InfoMergerBuilder<SchedeekInfo, SchedeekdatInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedeekMergerVisiSchedeekdat());
		InfoMerger<SchedeekInfo, SchedeekdatInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
