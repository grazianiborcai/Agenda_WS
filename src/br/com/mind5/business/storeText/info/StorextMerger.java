package br.com.mind5.business.storeText.info;

import java.util.List;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StorextMerger {
	public static List<StorextInfo> mergeWithMatextarch(List<StorextInfo> baseInfos, List<MatextarchInfo> selectedInfos) {
		InfoMergerBuilderV3<StorextInfo, MatextarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorextVisiMergeMatextarch());
		InfoMergerV3<StorextInfo, MatextarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorextInfo> mergeWithMatextault(List<StorextInfo> baseInfos, List<MatextaultInfo> selectedInfos) {
		InfoMergerBuilderV3<StorextInfo, MatextaultInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorextVisiMergeMatextault());
		InfoMergerV3<StorextInfo, MatextaultInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorextInfo> mergeWithUsername(List<StorextInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<StorextInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorextVisiMergeUsername());
		InfoMergerV3<StorextInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorextInfo> mergeToSelect(List<StorextInfo> baseInfos, List<StorextInfo> selectedInfos) {
		InfoMergerBuilderV3<StorextInfo, StorextInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorextVisiMergeToSelect());
		InfoMergerV3<StorextInfo, StorextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorextInfo> mergeToDelete(List<StorextInfo> baseInfos, List<StorextInfo> selectedInfos) {
		InfoMergerBuilderV3<StorextInfo, StorextInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorextVisiMergeToDelete());
		InfoMergerV3<StorextInfo, StorextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorextInfo> mergeToUpdate(List<StorextInfo> baseInfos, List<StorextInfo> selectedInfos) {
		InfoMergerBuilderV3<StorextInfo, StorextInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorextVisiMergeToUpdate());
		InfoMergerV3<StorextInfo, StorextInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
