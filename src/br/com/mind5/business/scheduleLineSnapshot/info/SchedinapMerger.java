package br.com.mind5.business.scheduleLineSnapshot.info;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.userList.info.UselisInfo;

public final class SchedinapMerger {
	public static List<SchedinapInfo> mergeWithUselis(List<SchedinapInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedinapInfo, UselisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedinapVisiMergeUselis());
		InfoMergerV3<SchedinapInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<SchedinapInfo> mergeWithCuslis(List<SchedinapInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedinapInfo, CuslisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedinapVisiMergeCuslis());
		InfoMergerV3<SchedinapInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedinapInfo> mergeWithEmplis(List<SchedinapInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedinapInfo, EmplisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedinapVisiMergeEmplis());
		InfoMergerV3<SchedinapInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedinapInfo> mergeWithStolis(List<SchedinapInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedinapInfo, StolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedinapVisiMergeStolis());
		InfoMergerV3<SchedinapInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedinapInfo> mergeWithMatsnap(List<SchedinapInfo> baseInfos, List<MatsnapInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedinapInfo, MatsnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedinapVisiMergeMatsnap());
		InfoMergerV3<SchedinapInfo, MatsnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedinapInfo> mergeWithMatlis(List<SchedinapInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedinapInfo, MatlisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedinapVisiMergeMatlis());
		InfoMergerV3<SchedinapInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedinapInfo> mergeToSelect(List<SchedinapInfo> baseInfos, List<SchedinapInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedinapInfo, SchedinapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedinapVisiMergeToSelect());
		InfoMergerV3<SchedinapInfo, SchedinapInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
