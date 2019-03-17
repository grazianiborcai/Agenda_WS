package br.com.gda.business.materialStock.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

final class MatockMergerToUpdate extends InfoMerger<MatockInfo, MatockInfo, MatockInfo> {
	public MatockInfo merge(MatockInfo sourceOne, MatockInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatockVisiMergeToUpdate());
	}
	
	
	
	public List<MatockInfo> merge(List<MatockInfo> sourceOnes, List<MatockInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatockVisiMergeToUpdate());
	}
}
