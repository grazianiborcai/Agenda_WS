package br.com.gda.business.materialStore.info;

import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoWriter;

final class MatStoreMergerMat extends InfoWriter<MatStoreInfo, MatInfo, MatStoreInfo> {
	public MatStoreInfo merge(MatInfo sourceOne, MatStoreInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatStoreVisitorMat());
	}
	
	
	
	public List<MatStoreInfo> merge(List<MatInfo> sourceOnes, List<MatStoreInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatStoreVisitorMat());
	}
}
