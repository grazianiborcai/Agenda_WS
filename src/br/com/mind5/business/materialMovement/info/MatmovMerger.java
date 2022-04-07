package br.com.mind5.business.materialMovement.info;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class MatmovMerger {
	public static List<MatmovInfo> mergeWithMatmarch(List<MatmovInfo> baseInfos, List<MatmarchInfo> selectedInfos) {
		InfoMergerBuilder<MatmovInfo, MatmarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatmovMergerVisiMatmarch());
		InfoMerger<MatmovInfo, MatmarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatmovInfo> mergeWithMatock(List<MatmovInfo> baseInfos, List<MatockInfo> selectedInfos) {
		InfoMergerBuilder<MatmovInfo, MatockInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatmovMergerVisiMatock());
		InfoMerger<MatmovInfo, MatockInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatmovInfo> mergeWithMatlis(List<MatmovInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilder<MatmovInfo, MatlisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatmovMergerVisiMatlis());
		InfoMerger<MatmovInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatmovInfo> mergeWithUsername(List<MatmovInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<MatmovInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatmovMergerVisiUsername());
		InfoMerger<MatmovInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatmovInfo> mergeToSelect(List<MatmovInfo> baseInfos, List<MatmovInfo> selectedInfos) {
		InfoMergerBuilder<MatmovInfo, MatmovInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatmovMergerVisiToSelect());
		InfoMerger<MatmovInfo, MatmovInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
