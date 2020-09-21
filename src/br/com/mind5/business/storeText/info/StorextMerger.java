package br.com.mind5.business.storeText.info;

import java.util.List;

import br.com.mind5.business.storeTextDefault.info.StorextaultInfo;
import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StorextMerger {
	public static List<StorextInfo> mergeWithStorextarch(List<StorextInfo> baseInfos, List<StorextarchInfo> selectedInfos) {
		InfoMergerBuilderV3<StorextInfo, StorextarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorextVisiMergeStorextarch());
		InfoMergerV3<StorextInfo, StorextarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorextInfo> mergeWithStorextault(List<StorextInfo> baseInfos, List<StorextaultInfo> selectedInfos) {
		InfoMergerBuilderV3<StorextInfo, StorextaultInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorextVisiMergeStorextault());
		InfoMergerV3<StorextInfo, StorextaultInfo> merger = builder.build();		
	
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
