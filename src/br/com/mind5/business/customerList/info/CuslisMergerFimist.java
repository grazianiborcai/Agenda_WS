package br.com.mind5.business.customerList.info;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CuslisMergerFimist extends InfoMergerTemplate_<CuslisInfo, FimistInfo> {

	@Override protected InfoMergerVisitor_<CuslisInfo, FimistInfo> getVisitorHook() {
		return new CuslisVisiMergeFimist();
	}
	
	
	
	@Override protected InfoUniquifier<CuslisInfo> getUniquifierHook() {
		return new CuslisUniquifier();
	}
}
