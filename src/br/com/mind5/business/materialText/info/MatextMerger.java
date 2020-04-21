package br.com.mind5.business.materialText.info;

import java.util.List;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.username.info.UsernameInfo;

public final class MatextMerger {
	public static List<MatextInfo> mergeWithMatextarch(List<MatextInfo> baseInfos, List<MatextarchInfo> selectedInfos) {
		InfoMergerBuilderV3<MatextInfo, MatextarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatextVisiMergeMatextarch());
		InfoMergerV3<MatextInfo, MatextarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatextInfo> mergeWithMatextault(List<MatextInfo> baseInfos, List<MatextaultInfo> selectedInfos) {
		InfoMergerBuilderV3<MatextInfo, MatextaultInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatextVisiMergeMatextault());
		InfoMergerV3<MatextInfo, MatextaultInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatextInfo> mergeWithUsername(List<MatextInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<MatextInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatextVisiMergeUsername());
		InfoMergerV3<MatextInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatextInfo> mergeToSelect(List<MatextInfo> baseInfos, List<MatextInfo> selectedInfos) {
		InfoMergerBuilderV3<MatextInfo, MatextInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatextVisiMergeToSelect());
		InfoMergerV3<MatextInfo, MatextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatextInfo> mergeToDelete(List<MatextInfo> baseInfos, List<MatextInfo> selectedInfos) {
		InfoMergerBuilderV3<MatextInfo, MatextInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatextVisiMergeToDelete());
		InfoMergerV3<MatextInfo, MatextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatextInfo> mergeToUpdate(List<MatextInfo> baseInfos, List<MatextInfo> selectedInfos) {
		InfoMergerBuilderV3<MatextInfo, MatextInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatextVisiMergeToUpdate());
		InfoMergerV3<MatextInfo, MatextInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
