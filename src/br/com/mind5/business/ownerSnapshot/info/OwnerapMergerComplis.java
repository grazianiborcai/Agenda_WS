package br.com.mind5.business.ownerSnapshot.info;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

public final class OwnerapMergerComplis extends InfoMergerTemplate<OwnerapInfo, ComplisInfo>{

	@Override protected InfoMergerVisitor<OwnerapInfo, ComplisInfo> getVisitorHook() {
		return new OwnerapVisiMergeComplis();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerapInfo> getUniquifierHook() {
		return new OwnerapUniquifier();
	}
}
