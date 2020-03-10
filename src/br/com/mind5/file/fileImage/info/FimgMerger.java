package br.com.mind5.file.fileImage.info;

import java.util.List;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.username.info.UsernameInfo;

public final class FimgMerger {	
	public static List<FimgInfo> mergeWithFimarch(List<FimgInfo> baseInfos, List<FimarchInfo> selectedInfos) {
		InfoMergerBuilderV3<FimgInfo, FimarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgVisiMergeFimarch());
		InfoMergerV3<FimgInfo, FimarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FimgInfo> mergeWithFath(List<FimgInfo> baseInfos, List<FathInfo> selectedInfos) {
		InfoMergerBuilderV3<FimgInfo, FathInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgVisiMergeFath());
		InfoMergerV3<FimgInfo, FathInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FimgInfo> mergeWithUsername(List<FimgInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<FimgInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgVisiMergeUsername());
		InfoMergerV3<FimgInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FimgInfo> mergeToReplace(List<FimgInfo> baseInfos, List<FimgInfo> selectedInfos) {
		InfoMergerBuilderV3<FimgInfo, FimgInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgVisiMergeToReplace());
		InfoMergerV3<FimgInfo, FimgInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FimgInfo> mergeToSelect(List<FimgInfo> baseInfos, List<FimgInfo> selectedInfos) {
		InfoMergerBuilderV3<FimgInfo, FimgInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgVisiMergeToSelect());
		InfoMergerV3<FimgInfo, FimgInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<FimgInfo> mergeToDelete(List<FimgInfo> baseInfos, List<FimgInfo> selectedInfos) {
		InfoMergerBuilderV3<FimgInfo, FimgInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgVisiMergeToDelete());
		InfoMergerV3<FimgInfo, FimgInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FimgInfo> mergeToUpdate(List<FimgInfo> baseInfos, List<FimgInfo> selectedInfos) {
		InfoMergerBuilderV3<FimgInfo, FimgInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgVisiMergeToUpdate());
		InfoMergerV3<FimgInfo, FimgInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
