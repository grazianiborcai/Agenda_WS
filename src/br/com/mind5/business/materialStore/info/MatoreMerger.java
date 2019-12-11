package br.com.mind5.business.materialStore.info;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class MatoreMerger {
	public static MatoreInfo mergeWithMatorap(MatorapInfo sourceOne, MatoreInfo sourceTwo) {
		InfoMerger<MatoreInfo, MatorapInfo> merger = new MatoreMergerMatorap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatoreInfo> mergeWithMatorap(List<MatorapInfo> sourceOnes, List<MatoreInfo> sourceTwos) {
		InfoMerger<MatoreInfo, MatorapInfo> merger = new MatoreMergerMatorap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatoreInfo mergeWithMatorarch(MatorarchInfo sourceOne, MatoreInfo sourceTwo) {
		InfoMerger<MatoreInfo, MatorarchInfo> merger = new MatoreMergerMatorarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatoreInfo> mergeWithMatorarch(List<MatorarchInfo> sourceOnes, List<MatoreInfo> sourceTwos) {
		InfoMerger<MatoreInfo, MatorarchInfo> merger = new MatoreMergerMatorarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static MatoreInfo mergeWithMatlis(MatlisInfo sourceOne, MatoreInfo sourceTwo) {
		InfoMerger<MatoreInfo, MatlisInfo> merger = new MatoreMergerMatlis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatoreInfo> mergeWithMatlis(List<MatlisInfo> sourceOnes, List<MatoreInfo> sourceTwos) {
		InfoMerger<MatoreInfo, MatlisInfo> merger = new MatoreMergerMatlis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatoreInfo mergeWithStolis(StolisInfo sourceOne, MatoreInfo sourceTwo) {
		InfoMerger<MatoreInfo, StolisInfo> merger = new MatoreMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatoreInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<MatoreInfo> sourceTwos) {
		InfoMerger<MatoreInfo, StolisInfo> merger = new MatoreMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatoreInfo mergeWithMatock(MatockInfo sourceOne, MatoreInfo sourceTwo) {
		InfoMerger<MatoreInfo, MatockInfo> merger = new MatoreMergerMatock();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatoreInfo> mergeWithMatock(List<MatockInfo> sourceOnes, List<MatoreInfo> sourceTwos) {
		InfoMerger<MatoreInfo, MatockInfo> merger = new MatoreMergerMatock();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatoreInfo mergeWithUsername(UsernameInfo sourceOne, MatoreInfo sourceTwo) {
		InfoMerger<MatoreInfo, UsernameInfo> merger = new MatoreMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatoreInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<MatoreInfo> sourceTwos) {
		InfoMerger<MatoreInfo, UsernameInfo> merger = new MatoreMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatoreInfo mergeToSelect(MatoreInfo sourceOne, MatoreInfo sourceTwo) {
		InfoMerger<MatoreInfo, MatoreInfo> merger = new MatoreMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatoreInfo> mergeToSelect(List<MatoreInfo> sourceOnes, List<MatoreInfo> sourceTwos) {
		InfoMerger<MatoreInfo, MatoreInfo> merger = new MatoreMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatoreInfo mergeToDelete(MatoreInfo sourceOne, MatoreInfo sourceTwo) {
		InfoMerger<MatoreInfo, MatoreInfo> merger = new MatoreMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatoreInfo> mergeToDelete(List<MatoreInfo> sourceOnes, List<MatoreInfo> sourceTwos) {
		InfoMerger<MatoreInfo, MatoreInfo> merger = new MatoreMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatoreInfo mergeToUpdate(MatoreInfo sourceOne, MatoreInfo sourceTwo) {
		InfoMerger<MatoreInfo, MatoreInfo> merger = new MatoreMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatoreInfo> mergeToUpdate(List<MatoreInfo> sourceOnes, List<MatoreInfo> sourceTwos) {
		InfoMerger<MatoreInfo, MatoreInfo> merger = new MatoreMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
