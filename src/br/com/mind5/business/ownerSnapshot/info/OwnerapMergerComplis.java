package br.com.mind5.business.ownerSnapshot.info;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

public final class OwnerapMergerComplis extends InfoMergerTemplate_<OwnerapInfo, ComplisInfo>{

	@Override protected InfoMergerVisitor_<OwnerapInfo, ComplisInfo> getVisitorHook() {
		return new OwnerapVisiMergeComplis();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerapInfo> getUniquifierHook() {
		return new OwnerapUniquifier();
	}
}
