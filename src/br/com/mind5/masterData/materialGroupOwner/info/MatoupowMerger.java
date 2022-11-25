package br.com.mind5.masterData.materialGroupOwner.info;

import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class MatoupowMerger {
	public static List<MatoupowInfo> mergeWithMatoup(List<MatoupowInfo> baseInfos, List<MatoupInfo> selectedInfos) {
		InfoMergerBuilder<MatoupowInfo, MatoupInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoupowMergerVisiMatoup());
		InfoMerger<MatoupowInfo, MatoupInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatoupowInfo> mergeWithUsername(List<MatoupowInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<MatoupowInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoupowMergerVisiUsername());
		InfoMerger<MatoupowInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatoupowInfo> mergeWithMatoupSearch(List<MatoupowInfo> baseInfos, List<MatoupInfo> selectedInfos) {
		InfoMergerBuilder<MatoupowInfo, MatoupInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoupowMergerVisiMatoupSearch());
		InfoMerger<MatoupowInfo, MatoupInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatoupowInfo> mergeWithOwnelis(List<MatoupowInfo> baseInfos, List<OwnelisInfo> selectedInfos) {
		InfoMergerBuilder<MatoupowInfo, OwnelisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoupowMergerVisiOwnelis());
		InfoMerger<MatoupowInfo, OwnelisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatoupowInfo> mergeToSelect(List<MatoupowInfo> baseInfos, List<MatoupowInfo> selectedInfos) {
		InfoMergerBuilder<MatoupowInfo, MatoupowInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoupowMergerVisiToSelect());
		InfoMerger<MatoupowInfo, MatoupowInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatoupowInfo> mergeToUpdate(List<MatoupowInfo> baseInfos, List<MatoupowInfo> selectedInfos) {
		InfoMergerBuilder<MatoupowInfo, MatoupowInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoupowMergerVisiToUpdate());
		InfoMerger<MatoupowInfo, MatoupowInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
