package br.com.mind5.business.customer.info;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CusMergerFimist extends InfoMergerTemplate<CusInfo, FimistInfo> {

	@Override protected InfoMergerVisitor<CusInfo, FimistInfo> getVisitorHook() {
		return new CusVisiMergeFimist();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
