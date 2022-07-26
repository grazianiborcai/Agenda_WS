package br.com.mind5.message.emailScheduleConfirmation.info;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class EmulonMerger {
	public static List<EmulonInfo> mergeWithEmplis(List<EmulonInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilder<EmulonInfo, EmplisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmulonMergerVisiEmplis());
		InfoMerger<EmulonInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmulonInfo> mergeWithMatlis(List<EmulonInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilder<EmulonInfo, MatlisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmulonMergerVisiMatlis());
		InfoMerger<EmulonInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmulonInfo> mergeWithCuslis(List<EmulonInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilder<EmulonInfo, CuslisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmulonMergerVisiCuslis());
		InfoMerger<EmulonInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmulonInfo> mergeWithStolis(List<EmulonInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<EmulonInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmulonMergerVisiStolis());
		InfoMerger<EmulonInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
