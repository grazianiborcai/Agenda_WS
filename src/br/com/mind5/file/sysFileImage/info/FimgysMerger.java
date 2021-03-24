package br.com.mind5.file.sysFileImage.info;

import java.util.List;

import br.com.mind5.file.fileImageSnapshot.info.FimgnapInfo;
import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.file.fileRead.info.FreadInfo;
import br.com.mind5.file.sysFileImageSearch.info.FimgysarchInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class FimgysMerger {	
	public static List<FimgysInfo> mergeWithFimgnap(List<FimgysInfo> baseInfos, List<FimgnapInfo> selectedInfos) {
		InfoMergerBuilder<FimgysInfo, FimgnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgVisiMergeFimgnap());
		InfoMerger<FimgysInfo, FimgnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FimgysInfo> mergeWithFread(List<FimgysInfo> baseInfos, List<FreadInfo> selectedInfos) {
		InfoMergerBuilder<FimgysInfo, FreadInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgVisiMergeFread());
		InfoMerger<FimgysInfo, FreadInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FimgysInfo> mergeWithFimgysarch(List<FimgysInfo> baseInfos, List<FimgysarchInfo> selectedInfos) {
		InfoMergerBuilder<FimgysInfo, FimgysarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgysVisiMergeFimgysarch());
		InfoMerger<FimgysInfo, FimgysarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FimgysInfo> mergeWithFath(List<FimgysInfo> baseInfos, List<FathInfo> selectedInfos) {
		InfoMergerBuilder<FimgysInfo, FathInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgysVisiMergeFath());
		InfoMerger<FimgysInfo, FathInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FimgysInfo> mergeToReplace(List<FimgysInfo> baseInfos, List<FimgysInfo> selectedInfos) {
		InfoMergerBuilder<FimgysInfo, FimgysInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgysVisiMergeToReplace());
		InfoMerger<FimgysInfo, FimgysInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FimgysInfo> mergeToSelect(List<FimgysInfo> baseInfos, List<FimgysInfo> selectedInfos) {
		InfoMergerBuilder<FimgysInfo, FimgysInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgysVisiMergeToSelect());
		InfoMerger<FimgysInfo, FimgysInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<FimgysInfo> mergeToUpdate(List<FimgysInfo> baseInfos, List<FimgysInfo> selectedInfos) {
		InfoMergerBuilder<FimgysInfo, FimgysInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FimgysVisiMergeToUpdate());
		InfoMerger<FimgysInfo, FimgysInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
