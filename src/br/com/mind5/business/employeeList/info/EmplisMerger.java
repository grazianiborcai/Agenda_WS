package br.com.mind5.business.employeeList.info;

import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class EmplisMerger {
	public static List<EmplisInfo> mergeWithEmparch(List<EmplisInfo> baseInfos, List<EmparchInfo> selectedInfos) {
		InfoMergerBuilderV3<EmplisInfo, EmparchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplisVisiMergeEmparch());
		InfoMergerV3<EmplisInfo, EmparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmplisInfo> mergeWithPerarch(List<EmplisInfo> baseInfos, List<PerarchInfo> selectedInfos) {
		InfoMergerBuilderV3<EmplisInfo, PerarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplisVisiMergePerarch());
		InfoMergerV3<EmplisInfo, PerarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<EmplisInfo> mergeWithFimist(List<EmplisInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilderV3<EmplisInfo, FimistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplisVisiMergeFimist());
		InfoMergerV3<EmplisInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmplisInfo> mergeWithPersolis(List<EmplisInfo> baseInfos, List<PersolisInfo> selectedInfos) {
		InfoMergerBuilderV3<EmplisInfo, PersolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplisVisiMergePersolis());
		InfoMergerV3<EmplisInfo, PersolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmplisInfo> mergeToSelect(List<EmplisInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilderV3<EmplisInfo, EmplisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplisVisiMergeToSelect());
		InfoMergerV3<EmplisInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
