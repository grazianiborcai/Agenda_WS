package br.com.mind5.business.material.info;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatMergerFimist extends InfoMergerTemplate<MatInfo, FimistInfo> {

	@Override protected InfoMergerVisitor<MatInfo, FimistInfo> getVisitorHook() {
		return new MatVisiMergeFimist();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
