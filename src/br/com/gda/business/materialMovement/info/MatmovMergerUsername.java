package br.com.gda.business.materialMovement.info;

import java.util.List;

import br.com.gda.info.InfoMerger_;
import br.com.gda.security.username.info.UsernameInfo;

final class MatmovMergerUsername extends InfoMerger_<MatmovInfo, UsernameInfo, MatmovInfo> {
	public MatmovInfo merge(UsernameInfo sourceOne, MatmovInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatmovVisiMergeUsername());
	}
	
	
	
	public List<MatmovInfo> merge(List<UsernameInfo> sourceOnes, List<MatmovInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatmovVisiMergeUsername());
	}
}
