package br.com.mind5.business.material.info;

import java.util.List;

import br.com.mind5.authorization.storePartitionAuthorization.info.SytotauhInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.file.fileImageDecorated.info.FimecoInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
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
		builder.addVisitor(new MatMergerVisiMatubup());
		InfoMerger<MatInfo, MatubupInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithSytotauh(List<MatInfo> baseInfos, List<SytotauhInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, SytotauhInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatMergerVisiSytotauh());
		InfoMerger<MatInfo, SytotauhInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithFimeco(List<MatInfo> baseInfos, List<FimecoInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, FimecoInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatMergerVisiFimeco());
		InfoMerger<MatInfo, FimecoInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMateg(List<MatInfo> baseInfos, List<MategInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, MategInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatMergerVisiMateg());
		InfoMerger<MatInfo, MategInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMatext(List<MatInfo> baseInfos, List<MatextInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, MatextInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatMergerVisiMatext());
		InfoMerger<MatInfo, MatextInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMatype(List<MatInfo> baseInfos, List<MatypeInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, MatypeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatMergerVisiMatype());
		InfoMerger<MatInfo, MatypeInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMatoup(List<MatInfo> baseInfos, List<MatoupInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, MatoupInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatMergerVisiMatoup());
		InfoMerger<MatInfo, MatoupInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMatunit(List<MatInfo> baseInfos, List<MatunitInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, MatunitInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatMergerVisiMatunit());
		InfoMerger<MatInfo, MatunitInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithMatsnap(List<MatInfo> baseInfos, List<MatsnapInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, MatsnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatMergerVisiMatsnap());
		InfoMerger<MatInfo, MatsnapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeWithUsername(List<MatInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatMergerVisiUsername());
		InfoMerger<MatInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeToSelect(List<MatInfo> baseInfos, List<MatInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, MatInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatMergerVisiToSelect());
		InfoMerger<MatInfo, MatInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeToDelete(List<MatInfo> baseInfos, List<MatInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, MatInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatMergerVisiToDelete());
		InfoMerger<MatInfo, MatInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatInfo> mergeToUpdate(List<MatInfo> baseInfos, List<MatInfo> selectedInfos) {
		InfoMergerBuilder<MatInfo, MatInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatMergerVisiToUpdate());
		InfoMerger<MatInfo, MatInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
