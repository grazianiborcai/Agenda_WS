package br.com.gda.business.ownerSnapshot.info;

import br.com.gda.business.companyList.info.ComplisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

public final class OwnerapMergerComplis extends InfoMergerTemplate<OwnerapInfo, ComplisInfo>{

	@Override protected InfoMergerVisitor<OwnerapInfo, ComplisInfo> getVisitorHook() {
		return new OwnerapVisiMergeComplis();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerapInfo> getUniquifierHook() {
		return new OwnerapUniquifier();
	}
}
