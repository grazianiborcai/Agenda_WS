package br.com.mind5.business.material.info;

import java.util.List;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.business.masterData.info.MatGroupInfo;
import br.com.mind5.business.masterData.info.MatTypeInfo;
import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.username.info.UsernameInfo;

public final class MatMerger {
	public static List<MatInfo> mergeWithFimist(List<MatInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilderV3<MatInfo, FimistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeFimist());
		InfoMergerV3<MatInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMatCateg(List<MatInfo> baseInfos, List<MatCategInfo> selectedInfos) {
		InfoMergerBuilderV3<MatInfo, MatCategInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeMatCateg());
		InfoMergerV3<MatInfo, MatCategInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMatext(List<MatInfo> baseInfos, List<MatextInfo> selectedInfos) {
		InfoMergerBuilderV3<MatInfo, MatextInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeMatext());
		InfoMergerV3<MatInfo, MatextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMatType(List<MatInfo> baseInfos, List<MatTypeInfo> selectedInfos) {
		InfoMergerBuilderV3<MatInfo, MatTypeInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeMatType());
		InfoMergerV3<MatInfo, MatTypeInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMatGroup(List<MatInfo> baseInfos, List<MatGroupInfo> selectedInfos) {
		InfoMergerBuilderV3<MatInfo, MatGroupInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeMatGroup());
		InfoMergerV3<MatInfo, MatGroupInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMatUnit(List<MatInfo> baseInfos, List<MatUnitInfo> selectedInfos) {
		InfoMergerBuilderV3<MatInfo, MatUnitInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeMatUnit());
		InfoMergerV3<MatInfo, MatUnitInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMatsnap(List<MatInfo> baseInfos, List<MatsnapInfo> selectedInfos) {
		InfoMergerBuilderV3<MatInfo, MatsnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeMatsnap());
		InfoMergerV3<MatInfo, MatsnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithUsername(List<MatInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<MatInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeUsername());
		InfoMergerV3<MatInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeToSelect(List<MatInfo> baseInfos, List<MatInfo> selectedInfos) {
		InfoMergerBuilderV3<MatInfo, MatInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeToSelect());
		InfoMergerV3<MatInfo, MatInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeToDelete(List<MatInfo> baseInfos, List<MatInfo> selectedInfos) {
		InfoMergerBuilderV3<MatInfo, MatInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeToDelete());
		InfoMergerV3<MatInfo, MatInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeToUpdate(List<MatInfo> baseInfos, List<MatInfo> selectedInfos) {
		InfoMergerBuilderV3<MatInfo, MatInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeToUpdate());
		InfoMergerV3<MatInfo, MatInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
