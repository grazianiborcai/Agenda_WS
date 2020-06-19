package br.com.mind5.message.emailScheduleConfirmation.info;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class EmulonMerger {
	public static List<EmulonInfo> mergeWithEmplis(List<EmulonInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilderV3<EmulonInfo, EmplisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmulonVisiMergeEmplis());
		InfoMergerV3<EmulonInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmulonInfo> mergeWithMatlis(List<EmulonInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilderV3<EmulonInfo, MatlisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmulonVisiMergeMatlis());
		InfoMergerV3<EmulonInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmulonInfo> mergeWithCuslis(List<EmulonInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilderV3<EmulonInfo, CuslisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmulonVisiMergeCuslis());
		InfoMergerV3<EmulonInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmulonInfo> mergeWithStolis(List<EmulonInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilderV3<EmulonInfo, StolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmulonVisiMergeStolis());
		InfoMergerV3<EmulonInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
