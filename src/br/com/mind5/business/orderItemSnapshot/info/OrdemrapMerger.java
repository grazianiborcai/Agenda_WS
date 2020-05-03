package br.com.mind5.business.orderItemSnapshot.info;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

public final class OrdemrapMerger {
	public static List<OrdemrapInfo> mergeWithMat(List<OrdemrapInfo> baseInfos, List<MatInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdemrapInfo, MatInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdemrapVisiMergeMat());
		InfoMergerV3<OrdemrapInfo, MatInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdemrapInfo> mergeWithMatsnap(List<OrdemrapInfo> baseInfos, List<MatsnapInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdemrapInfo, MatsnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdemrapVisiMergeMatsnap());
		InfoMergerV3<OrdemrapInfo, MatsnapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdemrapInfo> mergeWithEmplis(List<OrdemrapInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdemrapInfo, EmplisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdemrapVisiMergeEmplis());
		InfoMergerV3<OrdemrapInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<OrdemrapInfo> mergeWithStolis(List<OrdemrapInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdemrapInfo, StolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdemrapVisiMergeStolis());
		InfoMergerV3<OrdemrapInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdemrapInfo> mergeWithWeekday(List<OrdemrapInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdemrapInfo, WeekdayInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdemrapVisiMergeWeekday());
		InfoMergerV3<OrdemrapInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}		
	
	
	
	public static List<OrdemrapInfo> mergeToSelect(List<OrdemrapInfo> baseInfos, List<OrdemrapInfo> selectedInfos) {
		InfoMergerBuilderV3<OrdemrapInfo, OrdemrapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdemrapVisiMergeToSelect());
		InfoMergerV3<OrdemrapInfo, OrdemrapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
