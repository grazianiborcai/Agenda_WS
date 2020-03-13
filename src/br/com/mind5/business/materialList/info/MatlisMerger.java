package br.com.mind5.business.materialList.info;

import java.util.List;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.business.masterData.info.MatGroupInfo;
import br.com.mind5.business.masterData.info.MatTypeInfo;
import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class MatlisMerger {
	public static List<MatlisInfo> mergeWithMatarch(List<MatlisInfo> baseInfos, List<MatarchInfo> selectedInfos) {
		InfoMergerBuilderV3<MatlisInfo, MatarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatlisVisiMergeMatarch());
		InfoMergerV3<MatlisInfo, MatarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatlisInfo> mergeWithMatCateg(List<MatlisInfo> baseInfos, List<MatCategInfo> selectedInfos) {
		InfoMergerBuilderV3<MatlisInfo, MatCategInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatlisVisiMergeMatCateg());
		InfoMergerV3<MatlisInfo, MatCategInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<MatlisInfo> mergeWithMatext(List<MatlisInfo> baseInfos, List<MatextInfo> selectedInfos) {
		InfoMergerBuilderV3<MatlisInfo, MatextInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatlisVisiMergeMatext());
		InfoMergerV3<MatlisInfo, MatextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatlisInfo> mergeWithMatType(List<MatlisInfo> baseInfos, List<MatTypeInfo> selectedInfos) {
		InfoMergerBuilderV3<MatlisInfo, MatTypeInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatlisVisiMergeMatType());
		InfoMergerV3<MatlisInfo, MatTypeInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatlisInfo> mergeWithMatGroup(List<MatlisInfo> baseInfos, List<MatGroupInfo> selectedInfos) {
		InfoMergerBuilderV3<MatlisInfo, MatGroupInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatlisVisiMergeMatGroup());
		InfoMergerV3<MatlisInfo, MatGroupInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatlisInfo> mergeWithMatUnit(List<MatlisInfo> baseInfos, List<MatUnitInfo> selectedInfos) {
		InfoMergerBuilderV3<MatlisInfo, MatUnitInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatlisVisiMergeMatUnit());
		InfoMergerV3<MatlisInfo, MatUnitInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatlisInfo> mergeToSelect(List<MatlisInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilderV3<MatlisInfo, MatlisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatlisVisiMergeToSelect());
		InfoMergerV3<MatlisInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
