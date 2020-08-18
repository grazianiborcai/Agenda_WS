package br.com.mind5.business.employeeMaterial.info;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.username.info.UsernameInfo;

public final class EmpmatMerger {
	public static List<EmpmatInfo> mergeWithEmpmarch(List<EmpmatInfo> baseInfos, List<EmpmarchInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpmatInfo, EmpmarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpmatVisiMergeEmpmarch());
		InfoMergerV3<EmpmatInfo, EmpmarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpmatInfo> mergeWithEmplis(List<EmpmatInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpmatInfo, EmplisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpmatVisiMergeEmplis());
		InfoMergerV3<EmpmatInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpmatInfo> mergeWithMatlis(List<EmpmatInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpmatInfo, MatlisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpmatVisiMergeMatlis());
		InfoMergerV3<EmpmatInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpmatInfo> mergeWithUsername(List<EmpmatInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpmatInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpmatVisiMergeUsername());
		InfoMergerV3<EmpmatInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpmatInfo> mergeToDelete(List<EmpmatInfo> baseInfos, List<EmpmatInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpmatInfo, EmpmatInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpmatVisiMergeToDelete());
		InfoMergerV3<EmpmatInfo, EmpmatInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmpmatInfo> mergeToSelect(List<EmpmatInfo> baseInfos, List<EmpmatInfo> selectedInfos) {
		InfoMergerBuilderV3<EmpmatInfo, EmpmatInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmpmatVisiMergeToSelect());
		InfoMergerV3<EmpmatInfo, EmpmatInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
