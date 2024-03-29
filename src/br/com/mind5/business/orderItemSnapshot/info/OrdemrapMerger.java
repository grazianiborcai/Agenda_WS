package br.com.mind5.business.orderItemSnapshot.info;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

public final class OrdemrapMerger {
	public static List<OrdemrapInfo> mergeWithCuslis(List<OrdemrapInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilder<OrdemrapInfo, CuslisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdemrapMergerVisiCuslis());
		InfoMerger<OrdemrapInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdemrapInfo> mergeWithMat(List<OrdemrapInfo> baseInfos, List<MatInfo> selectedInfos) {
		InfoMergerBuilder<OrdemrapInfo, MatInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdemrapMergerVisiMat());
		InfoMerger<OrdemrapInfo, MatInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdemrapInfo> mergeWithMatsnap(List<OrdemrapInfo> baseInfos, List<MatsnapInfo> selectedInfos) {
		InfoMergerBuilder<OrdemrapInfo, MatsnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdemrapMergerVisiMatsnap());
		InfoMerger<OrdemrapInfo, MatsnapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdemrapInfo> mergeWithEmplres(List<OrdemrapInfo> baseInfos, List<EmplresInfo> selectedInfos) {
		InfoMergerBuilder<OrdemrapInfo, EmplresInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdemrapMergerVisiEmplres());
		InfoMerger<OrdemrapInfo, EmplresInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdemrapInfo> mergeWithStolis(List<OrdemrapInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<OrdemrapInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdemrapMergerVisiStolis());
		InfoMerger<OrdemrapInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdemrapInfo> mergeWithWeekday(List<OrdemrapInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilder<OrdemrapInfo, WeekdayInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdemrapMergerVisiWeekday());
		InfoMerger<OrdemrapInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<OrdemrapInfo> mergeToSelect(List<OrdemrapInfo> baseInfos, List<OrdemrapInfo> selectedInfos) {
		InfoMergerBuilder<OrdemrapInfo, OrdemrapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdemrapMergerVisiToSelect());
		InfoMerger<OrdemrapInfo, OrdemrapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
