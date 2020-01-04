package br.com.mind5.business.customerList.info;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CuslisMergerFimist extends InfoMergerTemplate<CuslisInfo, FimistInfo> {

	@Override protected InfoMergerVisitor<CuslisInfo, FimistInfo> getVisitorHook() {
		return new CuslisVisiMergeFimist();
	}
	
	
	
	@Override protected InfoUniquifier<CuslisInfo> getUniquifierHook() {
		return new CuslisUniquifier();
	}
}
