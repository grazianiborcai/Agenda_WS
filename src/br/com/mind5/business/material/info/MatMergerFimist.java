package br.com.mind5.business.material.info;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatMergerFimist extends InfoMergerTemplate_<MatInfo, FimistInfo> {

	@Override protected InfoMergerVisitor_<MatInfo, FimistInfo> getVisitorHook() {
		return new MatVisiMergeFimist();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
