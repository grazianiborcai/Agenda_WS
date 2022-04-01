package br.com.mind5.business.company.info;

import java.util.List;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CompMerger {
	public static List<CompInfo> mergeWithCompnap(List<CompInfo> baseInfos, List<CompnapInfo> selectedInfos) {
		InfoMergerBuilder<CompInfo, CompnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CompMergerVisiCompnap());
		InfoMerger<CompInfo, CompnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CompInfo> mergeWithUsername(List<CompInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<CompInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CompMergerVisiUsername());
		InfoMerger<CompInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CompInfo> mergeToDelete(List<CompInfo> baseInfos, List<CompInfo> selectedInfos) {
		InfoMergerBuilder<CompInfo, CompInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CompMergerVisiToDelete());
		InfoMerger<CompInfo, CompInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CompInfo> mergeToSelect(List<CompInfo> baseInfos, List<CompInfo> selectedInfos) {
		InfoMergerBuilder<CompInfo, CompInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CompMergerVisiToSelect());
		InfoMerger<CompInfo, CompInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CompInfo> mergeToUpdate(List<CompInfo> baseInfos, List<CompInfo> selectedInfos) {
		InfoMergerBuilder<CompInfo, CompInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CompMergerVisiToUpdate());
		InfoMerger<CompInfo, CompInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
