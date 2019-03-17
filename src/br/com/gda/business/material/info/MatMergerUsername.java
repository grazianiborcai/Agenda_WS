package br.com.gda.business.material.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

final class MatMergerUsername extends InfoMerger<MatInfo, UsernameInfo, MatInfo> {
	public MatInfo merge(UsernameInfo sourceOne, MatInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatVisiMergeUsername());
	}
	
	
	
	public List<MatInfo> merge(List<UsernameInfo> sourceOnes, List<MatInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatVisiMergeUsername());
	}
}
