package br.com.mind5.business.material.info;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.materialCategory.info.MategInfo;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.masterData.materialType.info.MatypeInfo;
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class MatMerger {
	public static List<MatInfo> mergeWithMatubup(List<MatInfo> baseInfos, List<MatubupInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, MatubupInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeMatubup());
		InfoMerger<MatInfo, MatubupInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithSytotauh(List<MatInfo> baseInfos, List<SytotauhInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, SytotauhInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeSytotauh());
		InfoMerger<MatInfo, SytotauhInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithFimist(List<MatInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, FimistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeFimist());
		InfoMerger<MatInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMateg(List<MatInfo> baseInfos, List<MategInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, MategInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeMateg());
		InfoMerger<MatInfo, MategInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMatext(List<MatInfo> baseInfos, List<MatextInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, MatextInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeMatext());
		InfoMerger<MatInfo, MatextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMatype(List<MatInfo> baseInfos, List<MatypeInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, MatypeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeMatype());
		InfoMerger<MatInfo, MatypeInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMatoup(List<MatInfo> baseInfos, List<MatoupInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, MatoupInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeMatoup());
		InfoMerger<MatInfo, MatoupInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMatunit(List<MatInfo> baseInfos, List<MatunitInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, MatunitInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeMatunit());
		InfoMerger<MatInfo, MatunitInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMatsnap(List<MatInfo> baseInfos, List<MatsnapInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, MatsnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeMatsnap());
		InfoMerger<MatInfo, MatsnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithUsername(List<MatInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeUsername());
		InfoMerger<MatInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeToSelect(List<MatInfo> baseInfos, List<MatInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, MatInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeToSelect());
		InfoMerger<MatInfo, MatInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeToDelete(List<MatInfo> baseInfos, List<MatInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, MatInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeToDelete());
		InfoMerger<MatInfo, MatInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeToUpdate(List<MatInfo> baseInfos, List<MatInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, MatInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatVisiMergeToUpdate());
		InfoMerger<MatInfo, MatInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
