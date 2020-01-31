package br.com.mind5.business.customer.info;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CusMergerFimist extends InfoMergerTemplate_<CusInfo, FimistInfo> {

	@Override protected InfoMergerVisitor_<CusInfo, FimistInfo> getVisitorHook() {
		return new CusVisiMergeFimist();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
