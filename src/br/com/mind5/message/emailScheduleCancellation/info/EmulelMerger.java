package br.com.mind5.message.emailScheduleCancellation.info;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class EmulelMerger {
	public static List<EmulelInfo> mergeWithEmplis(List<EmulelInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilder<EmulelInfo, EmplisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmulelMergerVisiEmplis());
		InfoMerger<EmulelInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmulelInfo> mergeWithMatlis(List<EmulelInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilder<EmulelInfo, MatlisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmulelMergerVisiMatlis());
		InfoMerger<EmulelInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmulelInfo> mergeWithCuslis(List<EmulelInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilder<EmulelInfo, CuslisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmulelMergerVisiCuslis());
		InfoMerger<EmulelInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmulelInfo> mergeWithStolis(List<EmulelInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<EmulelInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmulelMergerVisiStolis());
		InfoMerger<EmulelInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
