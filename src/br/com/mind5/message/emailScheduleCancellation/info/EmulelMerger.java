package br.com.mind5.message.emailScheduleCancellation.info;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class EmulelMerger {
	public static List<EmulelInfo> mergeWithEmplis(List<EmulelInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilderV3<EmulelInfo, EmplisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmulelVisiMergeEmplis());
		InfoMergerV3<EmulelInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmulelInfo> mergeWithMatlis(List<EmulelInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilderV3<EmulelInfo, MatlisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmulelVisiMergeMatlis());
		InfoMergerV3<EmulelInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmulelInfo> mergeWithCuslis(List<EmulelInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilderV3<EmulelInfo, CuslisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmulelVisiMergeCuslis());
		InfoMergerV3<EmulelInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmulelInfo> mergeWithStolis(List<EmulelInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilderV3<EmulelInfo, StolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmulelVisiMergeStolis());
		InfoMergerV3<EmulelInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
