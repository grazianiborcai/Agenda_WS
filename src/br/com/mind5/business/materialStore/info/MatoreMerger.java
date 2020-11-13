package br.com.mind5.business.materialStore.info;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class MatoreMerger {
	public static List<MatoreInfo> mergeWithMatorap(List<MatoreInfo> baseInfos, List<MatorapInfo> selectedInfos) {
		InfoMergerBuilder<MatoreInfo, MatorapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoreVisiMergeMatorap());
		InfoMerger<MatoreInfo, MatorapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatoreInfo> mergeWithMatorarch(List<MatoreInfo> baseInfos, List<MatorarchInfo> selectedInfos) {
		InfoMergerBuilder<MatoreInfo, MatorarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoreVisiMergeMatorarch());
		InfoMerger<MatoreInfo, MatorarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatoreInfo> mergeWithMatlis(List<MatoreInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilder<MatoreInfo, MatlisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoreVisiMergeMatlis());
		InfoMerger<MatoreInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatoreInfo> mergeWithStolis(List<MatoreInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<MatoreInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoreVisiMergeStolis());
		InfoMerger<MatoreInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatoreInfo> mergeWithMatock(List<MatoreInfo> baseInfos, List<MatockInfo> selectedInfos) {
		InfoMergerBuilder<MatoreInfo, MatockInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoreVisiMergeMatock());
		InfoMerger<MatoreInfo, MatockInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatoreInfo> mergeWithUsername(List<MatoreInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<MatoreInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoreVisiMergeUsername());
		InfoMerger<MatoreInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatoreInfo> mergeToSelect(List<MatoreInfo> baseInfos, List<MatoreInfo> selectedInfos) {
		InfoMergerBuilder<MatoreInfo, MatoreInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoreVisiMergeToSelect());
		InfoMerger<MatoreInfo, MatoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatoreInfo> mergeToDelete(List<MatoreInfo> baseInfos, List<MatoreInfo> selectedInfos) {
		InfoMergerBuilder<MatoreInfo, MatoreInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoreVisiMergeToDelete());
		InfoMerger<MatoreInfo, MatoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<MatoreInfo> mergeToUpdate(List<MatoreInfo> baseInfos, List<MatoreInfo> selectedInfos) {
		InfoMergerBuilder<MatoreInfo, MatoreInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MatoreVisiMergeToUpdate());
		InfoMerger<MatoreInfo, MatoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
