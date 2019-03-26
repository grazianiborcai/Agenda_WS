package br.com.gda.business.materialText.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

final class MatextMergerUsername extends InfoMerger<MatextInfo, UsernameInfo, MatextInfo> {
	public MatextInfo merge(UsernameInfo sourceOne, MatextInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatextVisiMergeUsername());
	}
	
	
	
	public List<MatextInfo> merge(List<UsernameInfo> sourceOnes, List<MatextInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatextVisiMergeUsername());
	}
}
