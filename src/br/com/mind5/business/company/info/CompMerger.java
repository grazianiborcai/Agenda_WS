package br.com.mind5.business.company.info;

import java.util.List;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CompMerger {
	public static List<CompInfo> mergeWithCompnap(List<CompInfo> baseInfos, List<CompnapInfo> selectedInfos) {
		InfoMergerBuilderV3<CompInfo, CompnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CompVisiMergeCompnap());
		InfoMergerV3<CompInfo, CompnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CompInfo> mergeWithUsername(List<CompInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<CompInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CompVisiMergeUsername());
		InfoMergerV3<CompInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CompInfo> mergeToDelete(List<CompInfo> baseInfos, List<CompInfo> selectedInfos) {
		InfoMergerBuilderV3<CompInfo, CompInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CompVisiMergeToDelete());
		InfoMergerV3<CompInfo, CompInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CompInfo> mergeToSelect(List<CompInfo> baseInfos, List<CompInfo> selectedInfos) {
		InfoMergerBuilderV3<CompInfo, CompInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CompVisiMergeToSelect());
		InfoMergerV3<CompInfo, CompInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CompInfo> mergeToUpdate(List<CompInfo> baseInfos, List<CompInfo> selectedInfos) {
		InfoMergerBuilderV3<CompInfo, CompInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CompVisiMergeToUpdate());
		InfoMergerV3<CompInfo, CompInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
