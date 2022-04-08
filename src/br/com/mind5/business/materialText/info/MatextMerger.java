package br.com.mind5.business.materialText.info;

import java.util.List;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class MatextMerger {
	public static List<MatextInfo> mergeWithMatextarch(List<MatextInfo> baseInfos, List<MatextarchInfo> selectedInfos) {
		InfoMergerBuilder<MatextInfo, MatextarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatextMergerVisiMatextarch());
		InfoMerger<MatextInfo, MatextarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatextInfo> mergeWithMatextault(List<MatextInfo> baseInfos, List<MatextaultInfo> selectedInfos) {
		InfoMergerBuilder<MatextInfo, MatextaultInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatextMergerVisiMatextault());
		InfoMerger<MatextInfo, MatextaultInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatextInfo> mergeWithUsername(List<MatextInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<MatextInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatextMergerVisiUsername());
		InfoMerger<MatextInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatextInfo> mergeToSelect(List<MatextInfo> baseInfos, List<MatextInfo> selectedInfos) {
		InfoMergerBuilder<MatextInfo, MatextInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatextMergerVisiToSelect());
		InfoMerger<MatextInfo, MatextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatextInfo> mergeToDelete(List<MatextInfo> baseInfos, List<MatextInfo> selectedInfos) {
		InfoMergerBuilder<MatextInfo, MatextInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatextMergerVisiToDelete());
		InfoMerger<MatextInfo, MatextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatextInfo> mergeToUpdate(List<MatextInfo> baseInfos, List<MatextInfo> selectedInfos) {
		InfoMergerBuilder<MatextInfo, MatextInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatextMergerVisiToUpdate());
		InfoMerger<MatextInfo, MatextInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
