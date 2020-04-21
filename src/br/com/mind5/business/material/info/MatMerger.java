package br.com.mind5.business.material.info;

import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.materialCategory.info.MategInfo;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialType.info.MatypeInfo;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class MatMerger {
	public static List<MatInfo> mergeWithFimist(List<MatInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilderV3<MatInfo, FimistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeFimist());
		InfoMergerV3<MatInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMateg(List<MatInfo> baseInfos, List<MategInfo> selectedInfos) {
		InfoMergerBuilderV3<MatInfo, MategInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeMateg());
		InfoMergerV3<MatInfo, MategInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMatext(List<MatInfo> baseInfos, List<MatextInfo> selectedInfos) {
		InfoMergerBuilderV3<MatInfo, MatextInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeMatext());
		InfoMergerV3<MatInfo, MatextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMatype(List<MatInfo> baseInfos, List<MatypeInfo> selectedInfos) {
		InfoMergerBuilderV3<MatInfo, MatypeInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeMatype());
		InfoMergerV3<MatInfo, MatypeInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMatoup(List<MatInfo> baseInfos, List<MatoupInfo> selectedInfos) {
		InfoMergerBuilderV3<MatInfo, MatoupInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeMatoup());
		InfoMergerV3<MatInfo, MatoupInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMatunit(List<MatInfo> baseInfos, List<MatunitInfo> selectedInfos) {
		InfoMergerBuilderV3<MatInfo, MatunitInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeMatunit());
		InfoMergerV3<MatInfo, MatunitInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMatsnap(List<MatInfo> baseInfos, List<MatsnapInfo> selectedInfos) {
		InfoMergerBuilderV3<MatInfo, MatsnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeMatsnap());
		InfoMergerV3<MatInfo, MatsnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithUsername(List<MatInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<MatInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeUsername());
		InfoMergerV3<MatInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeToSelect(List<MatInfo> baseInfos, List<MatInfo> selectedInfos) {
		InfoMergerBuilderV3<MatInfo, MatInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeToSelect());
		InfoMergerV3<MatInfo, MatInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeToDelete(List<MatInfo> baseInfos, List<MatInfo> selectedInfos) {
		InfoMergerBuilderV3<MatInfo, MatInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeToDelete());
		InfoMergerV3<MatInfo, MatInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeToUpdate(List<MatInfo> baseInfos, List<MatInfo> selectedInfos) {
		InfoMergerBuilderV3<MatInfo, MatInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeToUpdate());
		InfoMergerV3<MatInfo, MatInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
