package br.com.mind5.business.employeeList.info;

import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class EmplisMerger {
	public static List<EmplisInfo> mergeWithEmparch(List<EmplisInfo> baseInfos, List<EmparchInfo> selectedInfos) {
		InfoMergerBuilder<EmplisInfo, EmparchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplisVisiMergeEmparch());
		InfoMerger<EmplisInfo, EmparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmplisInfo> mergeWithPerarch(List<EmplisInfo> baseInfos, List<PerarchInfo> selectedInfos) {
		InfoMergerBuilder<EmplisInfo, PerarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplisVisiMergePerarch());
		InfoMerger<EmplisInfo, PerarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<EmplisInfo> mergeWithFimist(List<EmplisInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilder<EmplisInfo, FimistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplisVisiMergeFimist());
		InfoMerger<EmplisInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmplisInfo> mergeWithPersolis(List<EmplisInfo> baseInfos, List<PersolisInfo> selectedInfos) {
		InfoMergerBuilder<EmplisInfo, PersolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplisVisiMergePersolis());
		InfoMerger<EmplisInfo, PersolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmplisInfo> mergeToSelect(List<EmplisInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilder<EmplisInfo, EmplisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmplisVisiMergeToSelect());
		InfoMerger<EmplisInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
