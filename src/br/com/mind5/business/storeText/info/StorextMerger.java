package br.com.mind5.business.storeText.info;

import java.util.List;

import br.com.mind5.business.storeTextDefault.info.StorextaultInfo;
import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StorextMerger {
	public static List<StorextInfo> mergeWithStorextarch(List<StorextInfo> baseInfos, List<StorextarchInfo> selectedInfos) {
		InfoMergerBuilder<StorextInfo, StorextarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorextVisiMergeStorextarch());
		InfoMerger<StorextInfo, StorextarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorextInfo> mergeWithStorextault(List<StorextInfo> baseInfos, List<StorextaultInfo> selectedInfos) {
		InfoMergerBuilder<StorextInfo, StorextaultInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorextVisiMergeStorextault());
		InfoMerger<StorextInfo, StorextaultInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorextInfo> mergeWithUsername(List<StorextInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<StorextInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorextVisiMergeUsername());
		InfoMerger<StorextInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorextInfo> mergeToSelect(List<StorextInfo> baseInfos, List<StorextInfo> selectedInfos) {
		InfoMergerBuilder<StorextInfo, StorextInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorextVisiMergeToSelect());
		InfoMerger<StorextInfo, StorextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorextInfo> mergeToDelete(List<StorextInfo> baseInfos, List<StorextInfo> selectedInfos) {
		InfoMergerBuilder<StorextInfo, StorextInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorextVisiMergeToDelete());
		InfoMerger<StorextInfo, StorextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StorextInfo> mergeToUpdate(List<StorextInfo> baseInfos, List<StorextInfo> selectedInfos) {
		InfoMergerBuilder<StorextInfo, StorextInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StorextVisiMergeToUpdate());
		InfoMerger<StorextInfo, StorextInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
