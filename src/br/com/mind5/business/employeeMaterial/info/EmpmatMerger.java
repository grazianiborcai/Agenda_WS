package br.com.mind5.business.employeeMaterial.info;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class EmpmatMerger {
	public static List<EmpmatInfo> mergeWithEmpmarch(List<EmpmatInfo> baseInfos, List<EmpmarchInfo> selectedInfos) {
		InfoMergerBuilder<EmpmatInfo, EmpmarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpmatVisiMergeEmpmarch());
		InfoMerger<EmpmatInfo, EmpmarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpmatInfo> mergeWithEmplis(List<EmpmatInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilder<EmpmatInfo, EmplisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpmatVisiMergeEmplis());
		InfoMerger<EmpmatInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpmatInfo> mergeWithMatlis(List<EmpmatInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilder<EmpmatInfo, MatlisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpmatVisiMergeMatlis());
		InfoMerger<EmpmatInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpmatInfo> mergeWithUsername(List<EmpmatInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<EmpmatInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpmatVisiMergeUsername());
		InfoMerger<EmpmatInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpmatInfo> mergeToDelete(List<EmpmatInfo> baseInfos, List<EmpmatInfo> selectedInfos) {
		InfoMergerBuilder<EmpmatInfo, EmpmatInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpmatVisiMergeToDelete());
		InfoMerger<EmpmatInfo, EmpmatInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpmatInfo> mergeToSelect(List<EmpmatInfo> baseInfos, List<EmpmatInfo> selectedInfos) {
		InfoMergerBuilder<EmpmatInfo, EmpmatInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpmatVisiMergeToSelect());
		InfoMerger<EmpmatInfo, EmpmatInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
