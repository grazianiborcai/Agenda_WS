package br.com.mind5.business.materialMovement.info;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.username.info.UsernameInfo;

public final class MatmovMerger {
	public static List<MatmovInfo> mergeWithMatmarch(List<MatmovInfo> baseInfos, List<MatmarchInfo> selectedInfos) {
		InfoMergerBuilderV3<MatmovInfo, MatmarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatmovVisiMergeMatmarch());
		InfoMergerV3<MatmovInfo, MatmarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatmovInfo> mergeWithMatock(List<MatmovInfo> baseInfos, List<MatockInfo> selectedInfos) {
		InfoMergerBuilderV3<MatmovInfo, MatockInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatmovVisiMergeMatock());
		InfoMergerV3<MatmovInfo, MatockInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatmovInfo> mergeWithMatlis(List<MatmovInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilderV3<MatmovInfo, MatlisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatmovVisiMergeMatlis());
		InfoMergerV3<MatmovInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatmovInfo> mergeWithUsername(List<MatmovInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<MatmovInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatmovVisiMergeUsername());
		InfoMergerV3<MatmovInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatmovInfo> mergeToSelect(List<MatmovInfo> baseInfos, List<MatmovInfo> selectedInfos) {
		InfoMergerBuilderV3<MatmovInfo, MatmovInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatmovVisiMergeToSelect());
		InfoMergerV3<MatmovInfo, MatmovInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
